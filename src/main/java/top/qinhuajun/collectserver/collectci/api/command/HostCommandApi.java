package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostRemoveVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;
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
    public PayloadVO<Long> createHost(@RequestBody HostCreateVO vo) {
        HostDTO dto = VOMapper.INSTANCE.toDTO(vo);
        Long id = hostCommandService.createHost(dto);
        return PayloadVO.success(id);
    }

    @PutMapping(path = "/{id}")
    public PayloadVO<String> updateHost(@PathVariable(name = "id") Long id, @RequestBody HostUpdateVO vo) {
        HostDTO dto = VOMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        hostCommandService.updateHost(dto);
        return PayloadVO.success(null);
    }

    @DeleteMapping(path = "/{id}")
    public PayloadVO<String> removeHost(@PathVariable(name = "id") Long id) {
        hostCommandService.removeHost(id);
        return PayloadVO.success(null);
    }

    @DeleteMapping
    public PayloadVO<String> removeHosts(HostRemoveVO vo) {
        hostCommandService.removeHosts(vo.getIds());
        return PayloadVO.success(null);
    }
}
