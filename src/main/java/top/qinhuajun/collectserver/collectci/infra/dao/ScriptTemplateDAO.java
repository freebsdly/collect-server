package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_script_templates")
public class ScriptTemplateDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String name;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String format;

    @Column(length = 50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String suffix;

    @NotBlank
    @NotEmpty
    @NotNull
    private String content;

    @NotBlank
    @NotEmpty
    @NotNull
    String os;

}