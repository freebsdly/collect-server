package top.qinhuajun.collectserver.collectci.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileContentDAO;

import java.util.Optional;

@Repository
public interface FileContentRepository extends JpaRepository<FileContentDAO, Long>, QuerydslPredicateExecutor<FileContentDAO> {

    Optional<FileContentDAO> findByIpAndPath(String ip, String path);
}