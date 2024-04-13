package top.qinhuajun.collectserver.collectci.infra.dao;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class CommonDAO {

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;
}
