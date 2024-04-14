package top.qinhuajun.collectserver.collectci.api.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(name = "更新主机请求体")
public class HostUpdateOptions {
    @Schema(example = "HFEA1MESAP01", requiredMode = Schema.RequiredMode.REQUIRED)
    String hostname;

    @Schema(example = "10.102.79.83", requiredMode = Schema.RequiredMode.REQUIRED)
    String ip;

    @Schema(example = "FDC", requiredMode = Schema.RequiredMode.REQUIRED)
    String app;

    @Schema(example = "uat", requiredMode = Schema.RequiredMode.REQUIRED)
    String env;

    @Schema(example = "windows", requiredMode = Schema.RequiredMode.REQUIRED)
    String os;
}
