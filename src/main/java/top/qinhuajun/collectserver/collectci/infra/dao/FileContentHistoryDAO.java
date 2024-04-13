package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_file_content_history")
public class FileContentHistoryDAO extends CommonDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(length = 50)
    private String ip;

    @Column(length = 50)
    private String os;


    @Column(length = 1000)
    private String path;
    @Column(length = 1000)
    private String status;

    @Column(columnDefinition = "text")
    private String content;


}
