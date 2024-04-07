package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_hosts")
@NoArgsConstructor
@Getter
@Setter
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String hostname;

    @Column(columnDefinition = "cidr")
    @NotBlank
    @NotEmpty
    @NotNull
    private String ip;

    @Column(length = 50)
    private String app;

    @Column(length = 50)
    private String env;

}
