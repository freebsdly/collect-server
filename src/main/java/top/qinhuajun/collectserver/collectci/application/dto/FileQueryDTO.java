package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileQueryDTO extends PageQueryDTO {
    private String path;
    private String hostIp;

    private List<String> paths;
    private List<String> hostIps;
}
