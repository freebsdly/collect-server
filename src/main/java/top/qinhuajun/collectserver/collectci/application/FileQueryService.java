package top.qinhuajun.collectserver.collectci.application;

import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.internal.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.collectci.application.dto.FileQueryDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;
import top.qinhuajun.collectserver.collectci.infra.FileRepository;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.QFileDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.QHostDAO;

@Service
@Slf4j
public class FileQueryService {

    private final HostRepository hostRepository;
    private final FileRepository fileRepository;

    @Autowired
    public FileQueryService(HostRepository hostRepository, FileRepository fileRepository) {
        this.hostRepository = hostRepository;
        this.fileRepository = fileRepository;
    }

    public FileDTO getFile(Long id) {
        FileDAO file = fileRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("can not find file by id: %s", id)));
        return DTOMapper.INSTANCE.toDto(file);
    }

    public Page<FileDTO> getFiles(FileQueryDTO query) {
        PageRequest pageRequest = PageRequest.of(query.getPageNum(), query.getPageSize());
        BooleanBuilder builder = new BooleanBuilder();
        QFileDAO fileModel = QFileDAO.fileDAO;
        QHostDAO hostModel = QHostDAO.hostDAO;

        if (query.getPath() != null && !query.getPath().isEmpty()) {
            builder.and(fileModel.path.like(query.getPath()));
        }

        if (query.getHostIp() != null && !query.getHostIp().isEmpty()) {
            builder.and(hostModel.ip.like(query.getHostIp()));
        }

        return fileRepository.findAll(builder, pageRequest).map(DTOMapper.INSTANCE::toDto);
    }
}
