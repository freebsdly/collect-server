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
import top.qinhuajun.collectserver.common.api.Payload;

@Tag(name = "主机文件相关接口")
public interface FileCommandApiDoc {

    @Operation(summary = "创建主机文件", description = "创建主机文件")
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = FileCreateOptions.class)
    ))
    Payload<Long> createHostFile(FileCreateOptions vo);

    @Operation(summary = "更新主机文件", description = "更新主机文件")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = FileUpdateOptions.class)
    ))
    Payload<String> updateHostFile(Long id, FileUpdateOptions vo);

    @Operation(summary = "删除主机文件", description = "删除主机文件")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    Payload<String> removeHostFile(Long id);

    @Operation(summary = "批量删除主机文件", description = "批量删除主机文件")
    Payload<String> removeHostFiles(@ParameterObject FileRemoveOptions vo);
}
