package top.qinhuajun.collectserver.collectci.api.query.vo;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.Value;

import java.util.List;

@Value
public class HostQueryVO {

    @Parameter(description = "主机名列表", required = false, in = ParameterIn.QUERY)
    List<String> hostnames;

    @Parameter(description = "IP列表", required = false, in = ParameterIn.QUERY)
    List<String> ips;

    @Parameter(description = "应用列表", required = false, in = ParameterIn.QUERY)
    List<String> apps;

    @Parameter(description = "环境列表", required = false, in = ParameterIn.QUERY)
    List<String> envs;

    @Parameter(description = "当前页", required = false, example = "1", in = ParameterIn.QUERY)
    int pageNum = 1;

    @Parameter(description = "每页记录数量", required = false, example = "10", in = ParameterIn.QUERY)
    int pageSize = 10;

}
