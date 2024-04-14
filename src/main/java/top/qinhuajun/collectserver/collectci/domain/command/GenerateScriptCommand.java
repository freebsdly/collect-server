package top.qinhuajun.collectserver.collectci.domain.command;

import freemarker.template.Configuration;
import lombok.Getter;

import java.util.List;

@Getter
public class GenerateScriptCommand {

    Configuration freemarkerConfig;

    String ip;

    String pushServer;

    // 脚本模板
    String scriptTemplateContent;

    // 需要采集的文件路径
    List<String> files;

    // 需要采集的服务进程名称
    List<String> keyProcessNames;

}
