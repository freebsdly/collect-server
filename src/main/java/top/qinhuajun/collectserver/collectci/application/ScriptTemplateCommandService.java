package top.qinhuajun.collectserver.collectci.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.collectci.infra.ScriptTemplateRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.ScriptTemplateDAO;

import java.util.Set;

@Service
@Slf4j
public class ScriptTemplateCommandService {

    private final ScriptTemplateRepository scriptTemplateRepository;

    @Autowired
    public ScriptTemplateCommandService(ScriptTemplateRepository scriptTemplateRepository) {
        this.scriptTemplateRepository = scriptTemplateRepository;
    }

    public Long createScriptTemplate(ScriptTemplateDTO dto) {
        ScriptTemplateDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        scriptTemplateRepository.save(entity);
        return entity.getId();
    }

    public void updateScriptTemplate(ScriptTemplateDTO dto) {
        ScriptTemplateDAO entity = DTOMapper.INSTANCE.toEntity(dto);
        scriptTemplateRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException(String.format("can not find template with id:%s", dto.getId())));
        scriptTemplateRepository.save(entity);
    }

    public void removeScriptTemplate(Long id) {
        scriptTemplateRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("can not find template with id:%s", id)));
        scriptTemplateRepository.deleteById(id);
    }

    @Transactional
    public void removeScriptTemplates(Set<Long> ids) {
        ids.forEach(this::removeScriptTemplate);
    }
}
