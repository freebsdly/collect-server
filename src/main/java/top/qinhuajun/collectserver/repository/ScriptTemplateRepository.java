package top.qinhuajun.collectserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import top.qinhuajun.collectserver.repository.entity.ScriptTemplate;

@Repository
public interface ScriptTemplateRepository extends JpaRepository<ScriptTemplate, Long>, QuerydslPredicateExecutor<ScriptTemplate> {
}