package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
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

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50)
    private String format;

    @Column(length = 50)
    private String suffix;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Column(length = 50)
    String os;

}