package top.qinhuajun.collectserver.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payload<T> implements Serializable {

    int code;

    String message;

    T data;
}
