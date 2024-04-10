package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostScriptQueryVO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;

@Tag(name = "主机相关接口")
public interface HostQueryApiDoc {

    @Operation(description = "获取主机详情")
    PayloadVO<HostDTO> queryHost(Long id);

    @Operation(description = "查询主机列表")
    PayloadVO<PageVO<HostDTO>> queryHosts(@ParameterObject HostQueryVO query);

    @Operation(description = "查询主机采集脚本内容")
    String queryHostScript(@ParameterObject HostScriptQueryVO vo);
}
