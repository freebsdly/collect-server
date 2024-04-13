package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.api.query.vo.ScriptTemplateQueryVO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@Tag(name = "脚本模板相关接口")
public interface ScriptTemplateQueryApiDoc {

    @Operation(summary = "获取模板详情",description = "获取模板详情")
    PayloadVO<ScriptTemplateDTO> queryScriptTemplate(Long id);

    @Operation(summary = "查询模板列表", description = "查询模板列表")
    PayloadVO<PageVO<ScriptTemplateDTO>> queryScriptTemplates(@ParameterObject ScriptTemplateQueryVO query);
}
