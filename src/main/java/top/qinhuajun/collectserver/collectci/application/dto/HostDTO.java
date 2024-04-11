package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HostDTO {
    private Long id;
    private String hostname;
    private String ip;
    private String app;
    private String env;
    private String os;
    private String monitor;

}
