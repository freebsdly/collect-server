package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.common.api.PageVO;
import top.qinhuajun.collectserver.common.api.Payload;

@Tag(name = "脚本模板相关接口")
public interface ScriptTemplateQueryApiDoc {

    @Operation(summary = "获取模板详情",description = "获取模板详情")
    Payload<ScriptTemplateDTO> queryScriptTemplate(Long id);

    @Operation(summary = "查询模板列表", description = "查询模板列表")
    Payload<PageVO<ScriptTemplateDTO>> queryScriptTemplates(@ParameterObject ScriptTemplateQueryOptions query);
}
