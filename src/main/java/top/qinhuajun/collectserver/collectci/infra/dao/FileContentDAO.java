package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_file_contents", uniqueConstraints = {@UniqueConstraint(columnNames = {"ip", "path"})})
public class FileContentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(length = 50, nullable = false)
    private String ip;

    @Column(length = 50)
    private String os;

    @Column(length = 1000, nullable = false)
    private String path;

    @Column(length = 1000)
    private String status;

    @Column(columnDefinition = "text")
    private String content;


}
