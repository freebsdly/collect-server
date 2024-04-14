package top.qinhuajun.collectserver.collectci.api.query;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.qinhuajun.collectserver.common.api.PageQueryOptions;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileQueryOptions extends PageQueryOptions {

    @Parameter(description = "路径列表", required = false, in = ParameterIn.QUERY)
    List<String> paths;

    @Parameter(description = "主机IP列表", required = false, in = ParameterIn.QUERY)
    List<Long> hostIps;
}
