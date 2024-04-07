package top.qinhuajun.collectserver.collectci.domain.model;

import lombok.Value;

public record File(String path, String format, String suffix) {
}
