package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.FileContentDTO;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.collectci.infra.FileContentRepository;
import top.qinhuajun.collectserver.collectci.infra.FileRepository;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileContentDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.FileDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FileCommandService {

    private final FileRepository fileRepository;
    private final HostRepository hostRepository;
    private final FileContentRepository fileContentRepository;
    private final FileSyncCommandService fileSyncCommandService;

    @Autowired
    public FileCommandService(FileRepository fileRepository, HostRepository hostRepository, FileContentRepository fileContentRepository, FileSyncCommandService fileSyncCommandService) {
        this.fileRepository = fileRepository;
        this.hostRepository = hostRepository;
        this.fileContentRepository = fileContentRepository;
        this.fileSyncCommandService = fileSyncCommandService;
    }

    public Long createHostFile(FileDTO dto) {
        HostDAO host = hostRepository.findById(dto.getHost().getId()).orElseThrow(() -> new RuntimeException(String.format("can not find host with id %s", dto.getHost().getId())));
        FileDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        fileRepository.save(entity);
        return entity.getId();
    }

    @Transactional
    public List<Long> createHostFiles(List<FileDTO> dto) {
        return dto.stream().map(this::createHostFile).toList();
    }

    public void removeHostFile(FileDTO dto) {
        fileRepository.delete(DTOMapper.INSTANCE.toEntity(dto));
    }

    @Transactional
    public void removeHostFiles(List<FileDTO> dto) {
        dto.forEach(this::removeHostFile);
    }

    @Transactional
    public Long createFileContent(FileContentDTO dto) {
        FileContentDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        Optional<FileContentDAO> exist = fileContentRepository.findByIpAndPath(dto.getIp(), dto.getPath());
        exist.ifPresent(fileContentDAO -> entity.setId(fileContentDAO.getId()));
        fileContentRepository.save(entity);
        fileSyncCommandService.add("record", dto);
        return entity.getId();
    }
}
