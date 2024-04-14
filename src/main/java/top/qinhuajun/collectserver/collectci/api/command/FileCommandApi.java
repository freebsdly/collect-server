package top.qinhuajun.collectserver.collectci.api.command;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.application.FileCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping("/hosts/files")
public class FileCommandApi implements FileCommandApiDoc{

    private final FileCommandService fileCommandService;

    @Autowired
    public FileCommandApi(FileCommandService fileCommandService) {
        this.fileCommandService = fileCommandService;
    }

    @PostMapping
    public Payload<Long> createHostFile(@RequestBody FileCreateOptions vo) {
        FileDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        Long fileId = fileCommandService.createHostFile(dto);
        return Payload.success(fileId);
    }

    @PutMapping(path = "/{fileId}")
    public Payload<String> updateHostFile(@PathVariable(name = "fileId") Long id, FileUpdateOptions vo) {
        FileDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        fileCommandService.updateHostFile(dto);
        return Payload.success();
    }

    @DeleteMapping(path = "/{fileId}")
    public Payload<String> removeHostFile(@PathVariable(name = "fileId") Long id) {
        fileCommandService.removeHostFile(id);
        return Payload.success();
    }

    @DeleteMapping
    public Payload<String> removeHostFiles(@ModelAttribute FileRemoveOptions vo) {
        fileCommandService.removeHostFiles(vo.getIds());
        return Payload.success();
    }
}
