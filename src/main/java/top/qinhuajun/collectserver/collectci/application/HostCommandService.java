package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.domain.HostAggregateRoot;

@Service
@Slf4j
public class HostCommandService {

    private HostAggregateRoot hostAgg;

    @Autowired
    HostCommandService(HostAggregateRoot hostAgg) {
        this.hostAgg = hostAgg;
    }

    public String createHost(HostDTO dto) {
        return "";
    }
}
