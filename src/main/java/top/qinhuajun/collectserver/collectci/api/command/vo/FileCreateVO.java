package top.qinhuajun.collectserver.collectci.api.command.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(name = "创建主机文件请求体")
public class FileCreateVO {

    @Schema(example = "/data01/a.cfg", requiredMode = Schema.RequiredMode.REQUIRED)
    String path;

    @Schema(example = "ini", requiredMode = Schema.RequiredMode.REQUIRED)
    String format;

    @Schema(example = "20", requiredMode = Schema.RequiredMode.REQUIRED)
    Long host;
}
