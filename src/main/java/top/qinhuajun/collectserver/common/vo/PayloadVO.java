package top.qinhuajun.collectserver.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "响应结果")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PayloadVO<T>(int code, String message, T data) {

    public static <R> PayloadVO<R> success() {
        return new PayloadVO<>(0, "success", null);
    }

    public static <R> PayloadVO<R> success(R data) {
        return new PayloadVO<>(0, "success", data);
    }

    public static <R> PayloadVO<R> failed(int code, R data) {
        return new PayloadVO<>(code, "failed", data);
    }
}
