package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.application.ScriptTemplateCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping("/scripts/templates")
public class ScriptTemplateCommandApi implements ScriptTemplateCommandApiDoc {

    private final ScriptTemplateCommandService scriptTemplateCommandService;

    @Autowired
    public ScriptTemplateCommandApi(ScriptTemplateCommandService scriptTemplateCommandService) {
        this.scriptTemplateCommandService = scriptTemplateCommandService;
    }

    @PostMapping
    public Payload<Long> createScriptTemplate(@RequestBody ScriptTemplateCreateOptions vo) {
        ScriptTemplateDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        Long id = scriptTemplateCommandService.createScriptTemplate(dto);
        return Payload.success(id);
    }

    @PutMapping(path = "/{id}")
    public Payload<String> updateScriptTemplate(@PathVariable(name = "id") Long id, @RequestBody ScriptTemplateUpdateOptions vo) {
        ScriptTemplateDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        scriptTemplateCommandService.updateScriptTemplate(dto);
        return Payload.success(null);
    }

    @DeleteMapping(path = "{id}")
    public Payload<String> removeScriptTemplate(@PathVariable(name = "id") Long id) {
        scriptTemplateCommandService.removeScriptTemplate(id);
        return Payload.success(null);
    }

    @DeleteMapping
    public Payload<String> removeScriptTemplates(ScriptTemplateRemoveOptions vo) {
        scriptTemplateCommandService.removeScriptTemplates(vo.getIds());
        return Payload.success(null);
    }
}
