package top.qinhuajun.collectserver.collectci.infra;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileDAO;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileDAO, Long>, QuerydslPredicateExecutor<FileDAO> {

    @EntityGraph(value = "file.host")
    List<FileDAO> findByHostId(Long hostId);
}