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
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostRemoveVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@Tag(name = "主机相关接口")
public interface HostCommandApiDoc {

    @Operation(description = "创建主机")
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = HostCreateVO.class)
    ))
    PayloadVO<Long> createHost(HostCreateVO vo);

    @Operation(description = "更新主机")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = HostUpdateVO.class)
    ))
    PayloadVO<String> updateHost(Long id, HostUpdateVO vo);

    @Operation(description = "删除主机")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    PayloadVO<String> removeHost(Long id);

    @Operation(description = "批量删除主机")
    PayloadVO<String> removeHosts(@ParameterObject HostRemoveVO vo);
}
