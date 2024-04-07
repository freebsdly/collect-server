package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.Value;

import java.util.List;

@Value
public class HostQueryDTO {

    String hostname;

    String ip;

    List<String> hostnames;

    List<String> ips;

    List<String> apps;

    List<String> envs;

    int pageSize;

    int pageNum;

    public int getPageNum() {
        if (pageNum > 1) {
            return pageNum;
        }
        return pageNum - 1;
    }
}
