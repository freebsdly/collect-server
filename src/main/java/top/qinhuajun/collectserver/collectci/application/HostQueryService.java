package top.qinhuajun.collectserver.collectci.application;

import com.querydsl.core.BooleanBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.*;
import top.qinhuajun.collectserver.collectci.infra.FileRepository;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.ScriptTemplateRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.FileDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.QHostDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.ScriptTemplateDAO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

@Service
@Slf4j
public class HostQueryService {

    final HostRepository hostRepository;
    final FileRepository fileRepository;
    final ScriptTemplateRepository scriptTemplateRepository;
    final Configuration freemarkerConfig;

    @Autowired
    public HostQueryService(HostRepository hostRepository, FileRepository fileRepository, ScriptTemplateRepository scriptTemplateRepository) {
        this.hostRepository = hostRepository;
        this.fileRepository = fileRepository;
        this.scriptTemplateRepository = scriptTemplateRepository;
        this.freemarkerConfig = initFreemarkerTemplateEngine();
    }

    public Configuration initFreemarkerTemplateEngine() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setDefaultEncoding("UTF-8");
        return configuration;
    }

    public HostDTO queryHost(Long id) {
        HostDAO host = hostRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("can not find host by id: %s", id)));
        return DTOMapper.INSTANCE.toDto(host);
    }

    public Page<HostDTO> queryHosts(HostQueryDTO query) {
        PageRequest pageRequest = PageRequest.of(query.getPageNum(), query.getPageSize());
        BooleanBuilder builder = new BooleanBuilder();
        QHostDAO hostModel = QHostDAO.hostDAO;
        if (query.getHostnames() != null && !query.getHostnames().isEmpty()) {
            builder.and(hostModel.hostname.in(query.getHostnames()));
        }
        if (query.getApps() != null && !query.getApps().isEmpty()) {
            builder.and(hostModel.app.in(query.getApps()));
        }
        if (query.getIps() != null && !query.getIps().isEmpty()) {
            builder.and(hostModel.ip.in(query.getIps()));
        }
        if (query.getEnvs() != null && !query.getEnvs().isEmpty()) {
            builder.and(hostModel.env.in(query.getEnvs()));
        }
        if (query.getHostname() != null && !query.getHostname().isEmpty()) {
            builder.and(hostModel.hostname.like(query.getHostname()));
        }
        if (query.getIp() != null && !query.getIp().isEmpty()) {
            builder.and(hostModel.ip.like(query.getIp()));
        }
        return hostRepository.findAll(builder, pageRequest).map(DTOMapper.INSTANCE::toDto);
    }

    public String generateScript(HostScriptQueryDTO dto) {
        HostDAO hostDAO = hostRepository.findByIp(dto.getIp()).orElseThrow(() -> new RuntimeException(String.format("can not find host by ip: %s", dto.getIp())));
        ScriptTemplateDAO scriptTemplateDAO = scriptTemplateRepository.findByOs(hostDAO.getOs()).orElseThrow(() -> new RuntimeException(String.format("can not find template by os: %s", hostDAO.getOs())));
        List<String> files = fileRepository.findByHostId(hostDAO.getId()).stream().map(FileDAO::getPath).toList();
        String templateContent = scriptTemplateDAO.getContent();
        ScriptTemplateModelDTO scriptTemplateModelDTO = new ScriptTemplateModelDTO();
        scriptTemplateModelDTO.setHost(hostDAO.getIp());
        scriptTemplateModelDTO.setServer("10.102.79.208:8080");
        scriptTemplateModelDTO.setFiles(files);
        return generateScript(templateContent, scriptTemplateModelDTO);
    }

    public String generateScript(String templateContent, ScriptTemplateModelDTO dto) {
        try {
            Template template = new Template("script", templateContent, this.freemarkerConfig);
            StringWriter writer = new StringWriter();
            template.process(dto, writer);
            return writer.toString();
        } catch (TemplateException | IOException e) {
            throw new HostScriptException(e);
        }

    }
}
