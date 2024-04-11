package top.qinhuajun.collectserver.collectci.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

import java.io.Serializable;

/**
 * DTO for {@link top.qinhuajun.collectserver.collectci.infra.dao.FileDAO}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Serializable {
    private Long id;
    private String path;
    private String format;
    @NotNull
    private HostDAO host;
}