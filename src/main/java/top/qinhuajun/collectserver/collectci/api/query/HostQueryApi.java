package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.application.HostQueryService;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostScriptQueryDTO;
import top.qinhuajun.collectserver.common.api.PageVO;
import top.qinhuajun.collectserver.common.api.Payload;

@RestController
@RequestMapping("/hosts")
public class HostQueryApi implements HostQueryApiDoc {

    final HostQueryService hostQueryService;

    @Autowired
    public HostQueryApi(HostQueryService hostQueryService) {
        this.hostQueryService = hostQueryService;
    }

    @GetMapping(path = {"/{hostId}"})
    public Payload<HostDTO> queryHost(@PathVariable(name = "hostId", required = true) Long id) {
        HostDTO hostDTO = hostQueryService.queryHost(id);
        return Payload.success(hostDTO);
    }

    @GetMapping
    public Payload<PageVO<HostDTO>> queryHosts(HostQueryOptions query) {
        HostQueryDTO queryDTO = QueryApiMapper.INSTANCE.toDTO(query);
        Page<HostDTO> page = hostQueryService.queryHosts(queryDTO);
        PageVO<HostDTO> hosts = QueryApiMapper.INSTANCE.toPageVo(query.getPageNum(), page);
        return Payload.success(hosts);
    }

    @GetMapping(path = "/scripts")
    public String queryHostScript(HostScriptQueryOptions vo) {
        HostScriptQueryDTO dto = QueryApiMapper.INSTANCE.toDTO(vo);
        return hostQueryService.generateScript(dto);
    }
}