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

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Transactional
    public Long createHostFile(FileDTO dto) {
        hostRepository.findById(dto.getHost().getId()).orElseThrow(() -> new RuntimeException(String.format("can not find host with id %s", dto.getHost().getId())));
        FileDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        fileRepository.save(entity);
        return entity.getId();
    }

    @Transactional
    public List<Long> createHostFiles(List<FileDTO> dto) {
        return dto.stream().map(this::createHostFile).toList();
    }

    @Transactional
    public void updateHostFile(FileDTO dto) {
        FileDAO entity = fileRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException(String.format("can not find file with id %s", dto.getId())));
        DTOMapper.INSTANCE.partialUpdate(dto, entity);
        fileRepository.save(entity);
    }

    @Transactional
    public void updateHostFiles(List<FileDTO> dto) {
        dto.forEach(this::updateHostFile);
    }

    @Transactional
    public void removeHostFile(Long id) {
        fileRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("can not find file with id %s", id)));
        fileContentRepository.deleteById(id);
    }

    @Transactional
    public void removeHostFiles(Set<Long> ids) {
        ids.forEach(this::removeHostFile);
    }

    @Transactional
    public void createFileContent(FileContentDTO dto) {
        Optional<FileContentDAO> exist = fileContentRepository.findByIpAndPath(dto.getIp(), dto.getPath());
        exist.ifPresent(entity ->{
            DTOMapper.INSTANCE.partialUpdate(dto, entity);
            fileContentRepository.save(entity);
            fileSyncCommandService.add("record", dto);
        });
    }
}
