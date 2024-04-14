package top.qinhuajun.collectserver.collectci.domain;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import top.qinhuajun.collectserver.collectci.application.HostScriptException;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateModelDTO;
import top.qinhuajun.collectserver.collectci.domain.command.GenerateScriptCommand;
import top.qinhuajun.collectserver.collectci.domain.event.ScriptGeneratedEvent;

import java.io.IOException;
import java.io.StringWriter;

public class ScriptAggregate {

    final Configuration freemarkerConfig;

    public ScriptAggregate(Configuration freemarkerConfig) {
        this.freemarkerConfig = freemarkerConfig;
    }

    public ScriptGeneratedEvent generateScript(GenerateScriptCommand command) {
        try {
            Template template = new Template("script", command.getScriptTemplateContent(), this.freemarkerConfig);
            StringWriter writer = new StringWriter();
            ScriptTemplateModelDTO value = new ScriptTemplateModelDTO();
            value.setFiles(command.getFiles());
            value.setHost(command.getIp());
            value.setServer(command.getPushServer());
            template.process(value, writer);
            return new ScriptGeneratedEvent(writer.toString());
        } catch (TemplateException | IOException e) {
            throw new HostScriptException(e);
        }
    }
}
