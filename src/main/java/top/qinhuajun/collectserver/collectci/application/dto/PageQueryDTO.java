package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryDTO {
    int pageSize;

    int pageNum;

    public int getPageNum() {
        if (pageNum >= 1) {
            return pageNum - 1;
        }
        return 0;
    }
}
