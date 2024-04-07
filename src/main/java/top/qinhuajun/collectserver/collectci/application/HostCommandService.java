package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.domain.HostAggregateRoot;
import top.qinhuajun.collectserver.collectci.infra.dao.Host;

import java.util.List;

@Service
@Log
public class HostCommandService {

    private HostAggregateRoot hostAgg;

    HostCommandService(@Autowired HostAggregateRoot hostAgg) {
        this.hostAgg = hostAgg;
    }
}
