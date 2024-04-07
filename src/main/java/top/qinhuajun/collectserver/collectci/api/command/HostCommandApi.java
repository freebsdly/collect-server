package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.collectci.api.doc.HostCommandApiDoc;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.HostCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;

@RestController
@RequestMapping("/hosts")
public class HostCommandApi implements HostCommandApiDoc {

    final HostCommandService hostCommandService;

    @Autowired
    public HostCommandApi(HostCommandService hostCommandService) {
        this.hostCommandService = hostCommandService;
    }

    @PostMapping
    public PayloadVo<String> createHost(@RequestBody(required = true) HostCreateVO vo) {
        HostDTO dto = VOMapper.INSTANCE.toDTO(vo);
        hostCommandService.createHost(dto);
        return PayloadVo.success("ok");
    }

    @PostMapping(path = "/{id}")
    public PayloadVo<String> updateHost(@PathVariable Long id, @RequestBody(required = true) HostUpdateVO vo) {
        HostDTO dto = VOMapper.INSTANCE.toDTO(vo);
        hostCommandService.createHost(dto);
        return PayloadVo.success("ok");
    }
}
