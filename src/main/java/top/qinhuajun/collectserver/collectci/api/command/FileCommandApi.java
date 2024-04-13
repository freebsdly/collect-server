package top.qinhuajun.collectserver.collectci.api.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.api.command.vo.*;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.FileCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@RestController
@RequestMapping("/hosts/files")
public class FileCommandApi implements FileCommandApiDoc{

    private final FileCommandService fileCommandService;

    @Autowired
    public FileCommandApi(FileCommandService fileCommandService) {
        this.fileCommandService = fileCommandService;
    }

    @PostMapping
    public PayloadVO<Long> createHostFile(@RequestBody FileCreateVO vo) {
        FileDTO dto = VOMapper.INSTANCE.toDTO(vo);
        Long fileId = fileCommandService.createHostFile(dto);
        return PayloadVO.success(fileId);
    }

    @PutMapping(path = "/{fileId}")
    public PayloadVO<String> updateHostFile(@PathVariable(name = "fileId") Long id, FileUpdateVO vo) {
        FileDTO dto = VOMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        fileCommandService.updateHostFile(dto);
        return PayloadVO.success();
    }

    @DeleteMapping(path = "/{fileId}")
    public PayloadVO<String> removeHostFile(@PathVariable(name = "fileId") Long id) {
        fileCommandService.removeHostFile(id);
        return PayloadVO.success();
    }

    @DeleteMapping
    public PayloadVO<String> removeHostFiles(FileRemoveVO vo) {
        fileCommandService.removeHostFiles(vo.getIds());
        return PayloadVO.success();
    }
}
