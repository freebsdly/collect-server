package top.qinhuajun.collectserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.api.vo.Payload;
import top.qinhuajun.collectserver.repository.entity.Host;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostApp {

    @GetMapping(path = {"", "/"})
    Payload<List<Host>> QueryHosts() {
        List<Host> hosts = List.of();
        return new Payload<List<Host>>(0, "ok", hosts);
    }
}
