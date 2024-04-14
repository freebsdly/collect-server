package top.qinhuajun.collectserver.common.api;

import org.springframework.data.domain.Page;

public interface PageMapper {

    default <T> PageVO<T> toPageVo(Page<T> page) {
        return new PageVO<>(page.getNumber(), page.getTotalPages(), page.getSize(), page.getTotalElements(), page.getContent());
    }

    default <T> PageVO<T> toPageVo(int current, Page<T> page) {
        return new PageVO<>(current, page.getTotalPages(), page.getSize(), page.getTotalElements(), page.getContent());
    }
}
