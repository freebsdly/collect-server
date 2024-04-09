package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HostDTO {
    Long id;
    String hostname;
    String ip;
    String app;
    String env;
}
