package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.domain.model.Host;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;

import java.util.List;

@Service
@Slf4j
public class HostQueryService {

    final HostRepository hostRepository;

    @Autowired
    public HostQueryService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Host QueryHosts() {
        log.debug("query options: {}", "options");
        return hostRepository.findAllById()
    }
}
