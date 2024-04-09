package top.qinhuajun.collectserver.collectci.application;

import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateQueryDTO;
import top.qinhuajun.collectserver.collectci.infra.ScriptTemplateRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.QScriptTemplateDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.ScriptTemplateDAO;

@Service
@Slf4j
public class ScriptTemplateQueryService {

    private final ScriptTemplateRepository scriptTemplateRepository;

    @Autowired
    public ScriptTemplateQueryService(ScriptTemplateRepository scriptTemplateRepository) {
        this.scriptTemplateRepository = scriptTemplateRepository;
    }

    public ScriptTemplateDTO queryScriptTemplate(Long id) {
        ScriptTemplateDAO template = scriptTemplateRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("can not find host by id: %s", id)));
        return DTOMapper.INSTANCE.toDto(template);
    }

    public Page<ScriptTemplateDTO> queryScriptTemplates(ScriptTemplateQueryDTO query) {
        PageRequest pageRequest = PageRequest.of(query.getPageNum(), query.getPageSize());
        BooleanBuilder builder = new BooleanBuilder();
        QScriptTemplateDAO qModel = QScriptTemplateDAO.scriptTemplateDAO;
        if (query.getNames() != null && !query.getNames().isEmpty()) {
            builder.and(qModel.name.in(query.getNames()));
        }
        if (query.getFormats() != null && !query.getFormats().isEmpty()) {
            builder.and(qModel.format.in(query.getFormats()));
        }
        if (query.getSuffix() != null && !query.getSuffix().isEmpty()) {
            builder.and(qModel.suffix.in(query.getSuffix()));
        }
        if (query.getName() != null && !query.getName().isEmpty()) {
            builder.and(qModel.name.like(query.getName()));
        }
        if (query.getFormat() != null && !query.getFormat().isEmpty()) {
            builder.and(qModel.format.like(query.getFormat()));
        }
        if (query.getSuffix() != null && !query.getSuffix().isEmpty()) {
            builder.and(qModel.suffix.like(query.getSuffix()));
        }
        return scriptTemplateRepository.findAll(builder, pageRequest).map(DTOMapper.INSTANCE::toDto);
    }
}
