package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostScriptQueryVO;
import top.qinhuajun.collectserver.collectci.application.dto.HostScriptQueryDTO;
import top.qinhuajun.collectserver.common.vo.PageVO;
import top.qinhuajun.collectserver.common.vo.PayloadVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.VOMapper;
import top.qinhuajun.collectserver.collectci.application.HostQueryService;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;

@RestController
@RequestMapping("/hosts")
public class HostQueryApi implements HostQueryApiDoc {

    final HostQueryService hostQueryService;

    @Autowired
    public HostQueryApi(HostQueryService hostQueryService) {
        this.hostQueryService = hostQueryService;
    }

    @GetMapping(path = {"/{id}"})
    public PayloadVO<HostDTO> queryHost(@PathVariable(name = "id", required = true) Long id) {
        HostDTO hostDTO = hostQueryService.queryHost(id);
        return PayloadVO.success(hostDTO);
    }

    @GetMapping
    public PayloadVO<PageVO<HostDTO>> queryHosts(HostQueryVO query) {
        HostQueryDTO queryDTO = VOMapper.INSTANCE.toDTO(query);
        Page<HostDTO> page = hostQueryService.queryHosts(queryDTO);
        PageVO<HostDTO> host = VOMapper.INSTANCE.toPageVo(query.getPageNum(), page);
        return PayloadVO.success(host);
    }

    @GetMapping(path = "/scripts")
    public String queryHostScript(HostScriptQueryVO vo) {
        HostScriptQueryDTO dto = VOMapper.INSTANCE.toDTO(vo);
        return hostQueryService.generateScript(dto);
    }
}