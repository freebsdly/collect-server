package top.qinhuajun.collectserver.collectci.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class WriteTimeDTO {

    private Instant createAt = Instant.now();
    private Instant updateAt = Instant.now();
}
