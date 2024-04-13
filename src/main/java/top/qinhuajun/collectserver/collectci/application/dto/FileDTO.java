package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

import java.io.Serializable;

/**
 * DTO for {@link top.qinhuajun.collectserver.collectci.infra.dao.FileDAO}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Serializable {
    private Long id;
    private String path;
    private String format;
    private HostDAO host;
}