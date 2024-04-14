package top.qinhuajun.collectserver.collectci.api.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.qinhuajun.collectserver.collectci.application.HostCommandService;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping("/hosts")
public class HostCommandApi implements HostCommandApiDoc {

    final HostCommandService hostCommandService;

    @Autowired
    public HostCommandApi(HostCommandService hostCommandService) {
        this.hostCommandService = hostCommandService;
    }

    @PostMapping
    public Payload<Long> createHost(@RequestBody HostCreateOptions vo) {
        HostDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        Long id = hostCommandService.createHost(dto);
        return Payload.success(id);
    }

    @PutMapping(path = "/{id}")
    public Payload<String> updateHost(@PathVariable(name = "id") Long id, @RequestBody HostUpdateOptions vo) {
        HostDTO dto = CommandApiMapper.INSTANCE.toDTO(vo);
        dto.setId(id);
        hostCommandService.updateHost(dto);
        return Payload.success(null);
    }

    @DeleteMapping(path = "/{id}")
    public Payload<String> removeHost(@PathVariable(name = "id") Long id) {
        hostCommandService.removeHost(id);
        return Payload.success(null);
    }

    @DeleteMapping
    public Payload<String> removeHosts(@ModelAttribute HostRemoveOptions vo) {
        hostCommandService.removeHosts(vo.getIds());
        return Payload.success(null);
    }
}
