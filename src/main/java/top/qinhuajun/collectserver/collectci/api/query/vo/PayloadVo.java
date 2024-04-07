package top.qinhuajun.collectserver.collectci.api.query.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PayloadVo<T> implements Serializable {

    int code;

    String message;

    T data;
}
