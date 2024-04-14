package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.application.FileCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.FileContentDTO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping(path = {"/envs", "/push"})
public class PushFileCommandApi implements PushFileCommandApiDoc {

    private final FileCommandService fileCommandService;

    @Autowired
    public PushFileCommandApi(FileCommandService fileCommandService) {
        this.fileCommandService = fileCommandService;
    }

    @PostMapping
    public Payload<String> pushFile(@ModelAttribute PushFileCreateOptions vo, @RequestBody(required = false) String content) {
        FileContentDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        dto.setContent(content);
        fileCommandService.createFileContent(dto);
        return Payload.success();
    }
}
