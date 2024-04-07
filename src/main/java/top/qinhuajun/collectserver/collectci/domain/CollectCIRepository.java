package top.qinhuajun.collectserver.collectci.domain;

import top.qinhuajun.collectserver.collectci.infra.dao.Host;

import java.util.Optional;

// 这是定义接口，实现放到infra中
public interface CollectCIRepository {

    Optional<Host> GetHostByAppAndIp(String app, String ip);
}
