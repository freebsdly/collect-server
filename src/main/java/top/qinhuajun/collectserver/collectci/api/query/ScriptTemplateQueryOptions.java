package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.*;
import top.qinhuajun.collectserver.common.api.PageQueryOptions;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScriptTemplateQueryOptions extends PageQueryOptions {
    @Parameter(description = "模板名称", required = false, in = ParameterIn.QUERY)
    List<String> names;

    @Parameter(description = "脚本模板格式", required = false, in = ParameterIn.QUERY)
    List<String> formats;

    @Parameter(description = "脚本模板后缀", required = false, in = ParameterIn.QUERY)
    List<String> suffixs;
}
