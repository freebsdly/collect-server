package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.ScriptTemplateQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.ScriptTemplateQueryService;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateQueryDTO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@RestController
@RequestMapping("/scripts/templates")
public class ScriptTemplateQueryApi implements ScriptTemplateQueryApiDoc {

    private final ScriptTemplateQueryService scriptTemplateQueryService;

    @Autowired
    public ScriptTemplateQueryApi(ScriptTemplateQueryService scriptTemplateQueryService) {
        this.scriptTemplateQueryService = scriptTemplateQueryService;
    }

    @GetMapping(path = "/{id}")
    public PayloadVO<ScriptTemplateDTO> queryScriptTemplate(@PathVariable(name = "id") Long id) {
        ScriptTemplateDTO scriptTemplateDTO = scriptTemplateQueryService.queryScriptTemplate(id);
        return PayloadVO.success(scriptTemplateDTO);
    }

    @GetMapping
    public PayloadVO<PageVO<ScriptTemplateDTO>> queryScriptTemplates(ScriptTemplateQueryVO query) {
        ScriptTemplateQueryDTO dto = VOMapper.INSTANCE.toDTO(query);
        Page<ScriptTemplateDTO> templates = scriptTemplateQueryService.queryScriptTemplates(dto);
        PageVO<ScriptTemplateDTO> pageVo = VOMapper.INSTANCE.toPageVo(query.getPageNum(), templates);
        return PayloadVO.success(pageVo);
    }
}
