package top.qinhuajun.collectserver.collectci.api.query.vo;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HostScriptQueryVO {

    @Parameter(description = "主机IP", required = true, in = ParameterIn.QUERY)
    private String ip;
}
