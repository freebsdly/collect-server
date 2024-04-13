package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link top.qinhuajun.collectserver.collectci.infra.dao.FileContentDAO}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileContentDTO extends WriteTimeDTO implements Serializable {
    private Long id;
    private String ip;
    private String os;
    private String path;
    private String status;
    private String content;
}