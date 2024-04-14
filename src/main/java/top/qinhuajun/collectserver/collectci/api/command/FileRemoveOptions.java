package top.qinhuajun.collectserver.collectci.api.command;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.util.Set;

@Value
@Schema(name = "删除主机文件参数")
public class FileRemoveOptions {

    @Parameter(description = "主机文件ID列表", required = true, in = ParameterIn.QUERY)
    Set<Long> ids;
}
