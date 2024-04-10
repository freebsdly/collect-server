package top.qinhuajun.collectserver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

public class TemplateEngineTests {

    public class Data {
        String host;
        String server;

        public String getHost() {
            return host;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public void setHost(String host) {
            this.host = host;
        }
    }

    @Test
    public void test() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setDefaultEncoding("UTF-8");

        String templateContent = """
                ${host}
                ${server}
                """;
        Template template = new Template("windows", templateContent, configuration);
        StringWriter writer = new StringWriter();
        Data data = new Data();
        data.setHost("10.128.255.32");
        data.setServer("10.102.79.208:8080");
        System.out.println(templateContent);
        template.process(data, writer);
        System.out.println(writer.toString());
    }
}
