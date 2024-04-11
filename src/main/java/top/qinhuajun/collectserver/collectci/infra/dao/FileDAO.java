package top.qinhuajun.collectserver.collectci.infra.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_host_files")
@NamedEntityGraph(
        name = "file.host"
        , attributeNodes = {@NamedAttributeNode(value = "host")}
)
public class FileDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(length = 1000)
    private String path;

    @Column(length = 50)
    private String format;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private HostDAO host;

}