package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HostQueryDTO extends PageQueryDTO {

    String hostname;

    String ip;

    List<String> hostnames;

    List<String> ips;

    List<String> apps;

    List<String> envs;
}
