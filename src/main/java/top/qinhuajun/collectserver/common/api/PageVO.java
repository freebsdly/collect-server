package top.qinhuajun.collectserver.common.api;

import java.util.List;

public record PageVO<T>(int currentPage, int totalPage, int pageSize, long total, List<T> data) {
}
