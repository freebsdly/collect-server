package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.FileQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.FileQueryService;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.collectci.application.dto.FileQueryDTO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;

@RestController
@RequestMapping("/hosts/files")
public class FileQueryApi implements FileQueryApiDoc {

    private final FileQueryService fileQueryService;

    @Autowired
    public FileQueryApi(FileQueryService fileQueryService) {
        this.fileQueryService = fileQueryService;
    }

    @GetMapping(path = "/{fileId}")
    public PayloadVO<FileDTO> queryFile(@PathVariable(name = "fileId") Long id) {
        FileDTO file = fileQueryService.getFile(id);
        return PayloadVO.success(file);
    }

    @GetMapping
    public PayloadVO<PageVO<FileDTO>> queryFiles(FileQueryVO query) {
        FileQueryDTO dto = VOMapper.INSTANCE.toDTO(query);
        Page<FileDTO> page = fileQueryService.getFiles(dto);
        PageVO<FileDTO> files = VOMapper.INSTANCE.toPageVo(query.getPageNum(), page);
        return PayloadVO.success(files);
    }
}
