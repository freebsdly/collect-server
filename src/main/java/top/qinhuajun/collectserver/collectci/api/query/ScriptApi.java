package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.ScriptVo;

import java.util.List;

@RestController
@RequestMapping("/scripts")
public class ScriptApi {

    @GetMapping(path = {"", "/"})
    PayloadVo<List<ScriptVo>> QueryTemplates() {
        List<ScriptVo> scripts = List.of();
        return new PayloadVo<List<ScriptVo>>(0, "ok", scripts);
    }
}
