package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateRemoveVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateUpdateVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.ScriptTemplateCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@RestController
@RequestMapping("/scripts/templates")
public class ScriptTemplateCommandApi implements ScriptTemplateCommandApiDoc {

    private final ScriptTemplateCommandService scriptTemplateCommandService;

    @Autowired
    public ScriptTemplateCommandApi(ScriptTemplateCommandService scriptTemplateCommandService) {
        this.scriptTemplateCommandService = scriptTemplateCommandService;
    }

    @PostMapping
    public PayloadVO<Long> createScriptTemplate(@RequestBody ScriptTemplateCreateVO vo) {
        ScriptTemplateDTO dto = VOMapper.INSTANCE.toDTO(vo);
        Long id = scriptTemplateCommandService.createScriptTemplate(dto);
        return PayloadVO.success(id);
    }

    @PutMapping(path = "/{id}")
    public PayloadVO<String> updateScriptTemplate(@PathVariable(name = "id") Long id, @RequestBody ScriptTemplateUpdateVO vo) {
        ScriptTemplateDTO dto = VOMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        scriptTemplateCommandService.updateScriptTemplate(dto);
        return PayloadVO.success(null);
    }

    @DeleteMapping(path = "{id}")
    public PayloadVO<String> removeScriptTemplate(@PathVariable(name = "id") Long id) {
        scriptTemplateCommandService.removeScriptTemplate(id);
        return PayloadVO.success(null);
    }

    @DeleteMapping
    public PayloadVO<String> removeScriptTemplates(ScriptTemplateRemoveVO vo) {
        scriptTemplateCommandService.removeScriptTemplates(vo.getIds());
        return PayloadVO.success(null);
    }
}
