package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HostQueryDTO extends PageQueryDTO {

    private String hostname;

    private String ip;

    private String os;

    private List<String> hostnames;

    private List<String> ips;

    private List<String> apps;

    private List<String> envs;
}
