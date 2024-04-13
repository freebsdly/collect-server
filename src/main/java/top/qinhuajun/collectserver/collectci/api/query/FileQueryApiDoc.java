package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import top.qinhuajun.collectserver.collectci.api.query.vo.FileQueryVO;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@Tag(name = "主机文件相关接口")
public interface FileQueryApiDoc {

    @Operation(summary = "获取主机文件详情", description = "获取主机文件详情")
    PayloadVO<FileDTO> queryFile(Long id);

    @Operation(summary = "查询主机文件列表", description = "查询主机文件列表")
    PayloadVO<PageVO<FileDTO>> queryFiles(@ParameterObject FileQueryVO query);
}
