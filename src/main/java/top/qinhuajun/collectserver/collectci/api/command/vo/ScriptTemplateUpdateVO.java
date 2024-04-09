package top.qinhuajun.collectserver.collectci.api.command.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(name = "更新脚本模板请求体")
public class ScriptTemplateUpdateVO {

    @Schema(example = "template for windows", requiredMode = Schema.RequiredMode.REQUIRED)
    String name;

    @Schema(example = "powershell", requiredMode = Schema.RequiredMode.REQUIRED)
    String format;

    @Schema(example = "ps1", requiredMode = Schema.RequiredMode.REQUIRED)
    String suffix;

    @Schema(example = "ls $env:", requiredMode = Schema.RequiredMode.REQUIRED)
    String content;
}
