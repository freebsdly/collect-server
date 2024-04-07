package top.qinhuajun.collectserver.collectci.api.query;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.qinhuajun.collectserver.collectci.api.query.vo.PayloadVo;
import top.qinhuajun.collectserver.collectci.api.query.vo.ScriptTemplateVo;

import java.util.List;

@RestController
@RequestMapping("/scripts/templates")
public class TemplateApi {

    @GetMapping(path = {"", "/"})
    PayloadVo<List<ScriptTemplateVo>> QueryTemplates() {
        List<ScriptTemplateVo> templates = List.of();
        return new PayloadVo<List<ScriptTemplateVo>>(0, "ok", templates);
    }
}
