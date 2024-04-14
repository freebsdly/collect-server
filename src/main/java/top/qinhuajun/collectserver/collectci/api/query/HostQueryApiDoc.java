package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.common.api.PageVO;
import top.qinhuajun.collectserver.common.api.Payload;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;

@Tag(name = "主机相关接口")
public interface HostQueryApiDoc {

    @Operation(summary = "获取主机详情", description = "获取主机详情")
    Payload<HostDTO> queryHost(Long id);

    @Operation(summary = "查询主机列表", description = "查询主机列表")
    Payload<PageVO<HostDTO>> queryHosts(@ParameterObject HostQueryOptions query);

    @Operation(summary = "查询主机采集脚本内容", description = "查询主机采集脚本内容")
    String queryHostScript(@ParameterObject HostScriptQueryOptions vo);
}
