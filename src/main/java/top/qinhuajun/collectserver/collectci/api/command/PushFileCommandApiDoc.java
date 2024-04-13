package top.qinhuajun.collectserver.collectci.api.command;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import top.qinhuajun.collectserver.collectci.api.command.vo.PushFileCreateVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@Tag(name = "文件推送相关接口")
public interface PushFileCommandApiDoc {

    @Operation(summary = "推送单个文件", description = "推送单个文件")
    @RequestBody(description = "文件内容，只支持文本", required = false, content = @Content(
            mediaType = MediaType.TEXT_PLAIN_VALUE,
            schema = @Schema(implementation = String.class)
    ))
    PayloadVO<String> pushFile(@ParameterObject PushFileCreateVO vo, String content);
}
