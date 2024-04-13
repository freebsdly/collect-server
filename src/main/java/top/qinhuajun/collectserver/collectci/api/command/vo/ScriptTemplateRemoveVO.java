package top.qinhuajun.collectserver.collectci.api.command.vo;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.Set;

@Value
@Schema(name = "删除脚本模板参数")
public class ScriptTemplateRemoveVO {

    @Parameter(description = "脚本模板ID列表", required = true, in = ParameterIn.QUERY)
    Set<Long> ids;
}
