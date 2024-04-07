package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.HostVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
import top.qinhuajun.collectserver.collectci.application.HostQueryService;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostApi {

    @Autowired
    HostQueryService hostQueryService;

    @GetMapping(path = {"", "/"})
    PayloadVo<List<HostVo>> QueryHosts() {
        List<HostVo> hosts = List.of();
        return new PayloadVo<List<HostVo>>(0, "ok", hosts);
    }
}
