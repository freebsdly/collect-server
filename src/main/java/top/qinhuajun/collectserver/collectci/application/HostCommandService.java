package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

import java.util.Set;

@Service
@Slf4j
public class HostCommandService {

    private final HostRepository hostRepository;

    @Autowired
    HostCommandService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Long createHost(HostDTO dto) {
        HostDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        hostRepository.save(entity);
        return entity.getId();
    }

    public void updateHost(HostDTO dto) {
        HostDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        hostRepository.findById(dto.getId()).orElseThrow(()-> new RuntimeException(String.format("can not find host with id:%s", dto.getId())));
        hostRepository.save(entity);
    }

    public void removeHost(Long id) {
        hostRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("can not find host with id:%s", id)));
        hostRepository.deleteById(id);
    }

    @Transactional
    public void removeHosts(Set<Long> ids) {
        ids.forEach(this::removeHost);
    }
}
