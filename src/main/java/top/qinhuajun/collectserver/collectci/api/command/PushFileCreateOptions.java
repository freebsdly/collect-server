package top.qinhuajun.collectserver.collectci.api.command;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(name = "推送文件参数")
public class PushFileCreateOptions {
    @Parameter(description = "IP地址", required = true, in = ParameterIn.QUERY)
    String ip;
    @Parameter(description = "操作系统 ", required = true, in = ParameterIn.QUERY)
    String os;
    @Parameter(description = "文件路径", required = true, in = ParameterIn.QUERY)
    String path;
    @Parameter(description = "采集状态", required = true, in = ParameterIn.QUERY)
    String status;
}
