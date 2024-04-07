package top.qinhuajun.collectserver.collectci.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

@Repository
public interface HostRepository extends JpaRepository<HostDAO, Long>, QuerydslPredicateExecutor<HostDAO> {
}