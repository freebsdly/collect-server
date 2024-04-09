package top.qinhuajun.collectserver.collectci.application;

import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import top.qinhuajun.collectserver.collectci.application.dto.DTOMapper;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;
import top.qinhuajun.collectserver.collectci.infra.HostRepository;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.QHostDAO;

@Service
@Slf4j
public class HostQueryService {

    final HostRepository hostRepository;

    @Autowired
    public HostQueryService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
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
        if (query.getEnvs() != null && !query.getEnvs().isEmpty()){
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
}
