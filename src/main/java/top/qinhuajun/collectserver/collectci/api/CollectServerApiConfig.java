package top.qinhuajun.collectserver.collectci.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.qinhuajun.collectserver.collectci.application.HostScriptException;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class CollectServerApiConfig {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HostScriptException.class)
    public String handleFreemarkerException(HostScriptException e) {
        log.error(e.getMessage());
        return "";
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public PayloadVO<String> HandleGlobalException(Exception ex) {
        log.error(Arrays.toString(ex.getStackTrace()));
        return new PayloadVO<>(1, "failed", ex.getMessage());
    }
}
