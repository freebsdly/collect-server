package top.qinhuajun.collectserver.collectci.api.query.vo;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.qinhuajun.collectserver.common.vo.PageQueryVO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileQueryVO extends PageQueryVO {

    @Parameter(description = "路径列表", required = false, in = ParameterIn.QUERY)
    List<String> paths;

    @Parameter(description = "主机IP列表", required = false, in = ParameterIn.QUERY)
    List<Long> hostIps;
}
