package top.qinhuajun.collectserver.collectci.api.query.vo;

import java.util.List;

public record PageVo<T>(int current, int total, int size, List<T> data) {
}
