package top.qinhuajun.collectserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;

import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class CollectServerApiConfig {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public PayloadVo<String> HandleGlobalException(Exception ex) {
        log.error(Arrays.toString(ex.getStackTrace()));
        return new PayloadVo<>(1, "failed", ex.getMessage());
    }
}
