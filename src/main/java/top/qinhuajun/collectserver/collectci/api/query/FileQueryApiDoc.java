package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.common.api.PageVO;
import top.qinhuajun.collectserver.common.api.Payload;

@Tag(name = "主机文件相关接口")
public interface FileQueryApiDoc {

    @Operation(summary = "获取主机文件详情", description = "获取主机文件详情")
    Payload<FileDTO> queryFile(Long id);

    @Operation(summary = "查询主机文件列表", description = "查询主机文件列表")
    Payload<PageVO<FileDTO>> queryFiles(@ParameterObject FileQueryOptions query);
}
