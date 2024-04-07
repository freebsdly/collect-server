package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.doc.HostQueryApiDoc;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostQueryVO;
import top.qinhuajun.collectserver.collectci.api.query.vo.PageVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
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
    public PayloadVo<HostDTO> queryHost(@PathVariable(name = "id", required = true) Long id) {
        HostDTO hostDTO = hostQueryService.queryHost(id);
        return PayloadVo.success(hostDTO);
    }

    @GetMapping
    public PayloadVo<PageVo<HostDTO>> queryHosts(HostQueryVO query) {
        HostQueryDTO queryDTO = VOMapper.INSTANCE.toDTO(query);
        Page<HostDTO> page = hostQueryService.queryHosts(queryDTO);
        PageVo<HostDTO> host = VOMapper.INSTANCE.toPageVo(query.getPageNum(), page);
        return PayloadVo.success(host);
    }
}