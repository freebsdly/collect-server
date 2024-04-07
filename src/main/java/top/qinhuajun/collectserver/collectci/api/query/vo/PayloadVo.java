package top.qinhuajun.collectserver.collectci.api.query.vo;

public record PayloadVo<T>(int code, String message, T data) {

    public static <R> PayloadVo<R> success(R data) {
        return new PayloadVo<>(0, "success", data);
    }

    public static <R> PayloadVo<R> failed(int code, R data) {
        return new PayloadVo<>(code, "failed", data);
    }
}
