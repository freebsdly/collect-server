package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.application.ScriptTemplateQueryService;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateQueryDTO;
import top.qinhuajun.collectserver.common.api.PageVO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping("/scripts/templates")
public class ScriptTemplateQueryApi implements ScriptTemplateQueryApiDoc {

    private final ScriptTemplateQueryService scriptTemplateQueryService;

    @Autowired
    public ScriptTemplateQueryApi(ScriptTemplateQueryService scriptTemplateQueryService) {
        this.scriptTemplateQueryService = scriptTemplateQueryService;
    }

    @GetMapping(path = "/{templateId}")
    public Payload<ScriptTemplateDTO> queryScriptTemplate(@PathVariable(name = "templateId") Long id) {
        ScriptTemplateDTO scriptTemplateDTO = scriptTemplateQueryService.queryScriptTemplate(id);
        return Payload.success(scriptTemplateDTO);
    }

    @GetMapping
    public Payload<PageVO<ScriptTemplateDTO>> queryScriptTemplates(@ModelAttribute ScriptTemplateQueryOptions query) {
        ScriptTemplateQueryDTO dto = QueryApiMapper.INSTANCE.toDTO(query);
        Page<ScriptTemplateDTO> templates = scriptTemplateQueryService.queryScriptTemplates(dto);
        PageVO<ScriptTemplateDTO> pageVo = QueryApiMapper.INSTANCE.toPageVo(query.getPageNum(), templates);
        return Payload.success(pageVo);
    }
}
