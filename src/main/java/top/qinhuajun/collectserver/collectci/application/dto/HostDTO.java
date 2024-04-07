package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.Value;

@Value
public class HostDTO {
    Long id;
    String hostname;
    String ip;
    String app;
    String env;
}
