package top.qinhuajun.collectserver.collectci.api.doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;

@Tag(name = "主机相关接口")
public interface HostCommandApiDoc {

    @Operation(description = "创建主机")
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = HostCreateVO.class)
    ))
    PayloadVo<String> createHost(HostCreateVO vo);

    @Operation(description = "更新主机")
    @Parameter(description = "主机ID", required = true, in = ParameterIn.PATH)
    @RequestBody(description = "请求体json", required = true, content = @Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = HostUpdateVO.class)
    ))
    PayloadVo<String> updateHost(Long id, HostUpdateVO vo);
}
