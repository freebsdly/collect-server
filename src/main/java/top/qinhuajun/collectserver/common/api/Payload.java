package top.qinhuajun.collectserver.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "响应结果")
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Payload<T>(int code, String message, T data) {

    public static <R> Payload<R> success() {
        return new Payload<>(0, "success", null);
    }

    public static <R> Payload<R> success(R data) {
        return new Payload<>(0, "success", data);
    }

    public static <R> Payload<R> failed(int code, R data) {
        return new Payload<>(code, "failed", data);
    }
}
