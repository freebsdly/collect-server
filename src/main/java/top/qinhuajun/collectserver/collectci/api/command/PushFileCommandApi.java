package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.command.vo.PushFileCreateVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.FileCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.FileContentDTO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@RestController
@RequestMapping(path = {"/envs", "/push"})
public class PushFileCommandApi implements PushFileCommandApiDoc {

    private final FileCommandService fileCommandService;

    @Autowired
    public PushFileCommandApi(FileCommandService fileCommandService) {
        this.fileCommandService = fileCommandService;
    }

    @PostMapping
    public PayloadVO<String> pushFile(PushFileCreateVO vo, @RequestBody(required = false) String content) {
        FileContentDTO dto = VOMapper.INSTANCE.toDTO(vo);
        dto.setContent(content);
        fileCommandService.createFileContent(dto);
        return PayloadVO.success();
    }
}
