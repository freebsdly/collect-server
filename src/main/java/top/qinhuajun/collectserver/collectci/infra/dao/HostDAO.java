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
public class HostDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(length = 100)
    private String hostname;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String ip;

    @NotEmpty
    @NotNull
    @Column(length = 50)
    private String app;

    @Column(length = 50)
    private String env;

}
