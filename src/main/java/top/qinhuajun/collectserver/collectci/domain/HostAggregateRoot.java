package top.qinhuajun.collectserver.collectci.domain;

import org.springframework.stereotype.Component;
import top.qinhuajun.collectserver.collectci.domain.model.ScriptTemplate;
import top.qinhuajun.collectserver.collectci.domain.model.File;

import java.util.List;

@Component
public class HostAggregateRoot extends AggregateRoot {

    // 需要采集的文件
    List<File> files;

    // 需要执行的脚本模板，基于模板和文件生产实际脚本；
    ScriptTemplate template;
}
