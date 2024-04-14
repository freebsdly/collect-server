package top.qinhuajun.collectserver.common.api;

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
public class PageQueryOptions {

    @Parameter(description = "当前页", required = false, example = "1", in = ParameterIn.QUERY)
    int pageNum = 1;

    @Parameter(description = "每页记录数量", required = false, example = "10", in = ParameterIn.QUERY)
    int pageSize = 10;
}
