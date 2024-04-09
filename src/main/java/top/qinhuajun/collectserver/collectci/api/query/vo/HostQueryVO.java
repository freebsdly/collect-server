package top.qinhuajun.collectserver.collectci.api.query.vo;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.*;
import top.qinhuajun.collectserver.common.vo.PageQueryVO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HostQueryVO extends PageQueryVO {

    @Parameter(description = "主机名列表", required = false, in = ParameterIn.QUERY)
    List<String> hostnames;

    @Parameter(description = "IP列表", required = false, in = ParameterIn.QUERY)
    List<String> ips;

    @Parameter(description = "应用列表", required = false, in = ParameterIn.QUERY)
    List<String> apps;

    @Parameter(description = "环境列表", required = false, in = ParameterIn.QUERY)
    List<String> envs;

}
