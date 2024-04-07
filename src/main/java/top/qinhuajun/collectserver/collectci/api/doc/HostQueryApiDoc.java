package top.qinhuajun.collectserver.collectci.api.doc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.PageVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;

@Tag(name = "主机相关接口")
public interface HostQueryApiDoc {

    @Operation(description = "获取主机详情")
    PayloadVo<HostDTO> queryHost(Long id);

    @Operation(description = "查询主机列表")
    PayloadVo<PageVo<HostDTO>> queryHosts(@ParameterObject HostQueryVO query);
}
