package top.qinhuajun.collectserver.collectci.api.command;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateRemoveVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateUpdateVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@Tag(name = "脚本模板相关接口")
public interface ScriptTemplateCommandApiDoc {

    @Operation(summary = "创建脚本模板", description = "创建脚本模板")
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ScriptTemplateCreateVO.class)
    ))
    PayloadVO<Long> createScriptTemplate(ScriptTemplateCreateVO vo);

    @Operation(summary = "更新脚本模板", description = "更新脚本模板")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = ScriptTemplateUpdateVO.class)
    ))
    PayloadVO<String> updateScriptTemplate(Long id, ScriptTemplateUpdateVO vo);

    @Operation(summary = "删除脚本模板", description = "删除脚本模板")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    PayloadVO<String> removeScriptTemplate(Long id);

    @Operation(summary = "批量删除脚本模板", description = "批量删除脚本模板")
    PayloadVO<String> removeScriptTemplates(@ParameterObject ScriptTemplateRemoveVO vo);
}
