package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class HostCommandService {

    private final HostRepository hostRepository;

    @Autowired
    HostCommandService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Transactional
    public Long createHost(HostDTO dto) {
        HostDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        hostRepository.save(entity);
        return entity.getId();
    }

    @Transactional
    public List<Long> createHosts(List<HostDTO> hosts) {
        return hosts.stream().map(this::createHost).toList();
    }

    @Transactional
    public void updateHost(HostDTO dto) {
        HostDAO entity = hostRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException(String.format("can not find host with id:%s", dto.getId())));
        DTOMapper.INSTANCE.partialUpdate(dto, entity);
        hostRepository.save(entity);
    }

    @Transactional
    public void updateHosts(Set<HostDTO> hosts) {
        hosts.forEach(this::updateHost);
    }

    @Transactional
    public void removeHost(Long id) {
        hostRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("can not find host with id:%s", id)));
        hostRepository.deleteById(id);
    }

    @Transactional
    public void removeHosts(Set<Long> ids) {
        ids.forEach(this::removeHost);
    }
}
