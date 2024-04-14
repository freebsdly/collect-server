package top.qinhuajun.collectserver.collectci.api.command;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import top.qinhuajun.collectserver.collectci.application.dto.FileContentDTO;
import top.qinhuajun.collectserver.collectci.application.dto.FileDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateDTO;
import top.qinhuajun.collectserver.common.api.PageMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommandApiMapper extends PageMapper {

    CommandApiMapper INSTANCE = Mappers.getMapper(CommandApiMapper.class);

    HostDTO toDTO(HostCreateOptions vo);

    HostDTO toDTO(HostUpdateOptions vo);

    ScriptTemplateDTO toDTO(ScriptTemplateCreateOptions vo);

    ScriptTemplateDTO toDTO(ScriptTemplateUpdateOptions vo);

    @Mapping(source = "host", target = "host.id")
    FileDTO toDTO(FileCreateOptions vo);

    @Mapping(source = "host", target = "host.id")
    FileDTO toDTO(FileUpdateOptions vo);

    FileContentDTO toDTO(PushFileCreateOptions vo);
}
