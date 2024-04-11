package top.qinhuajun.collectserver.collectci.application.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import top.qinhuajun.collectserver.collectci.infra.dao.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DTOMapper.class})
public interface DTOMapper {

    DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

    HostDAO toEntity(HostDTO hostDTO);

    HostDTO toDto(HostDAO host);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    HostDAO partialUpdate(HostDTO hostDTO, @MappingTarget HostDAO host);

    ScriptTemplateDTO toDto(ScriptTemplateDAO dao);

    ScriptTemplateDAO toEntity(ScriptTemplateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScriptTemplateDAO partialUpdate(ScriptTemplateDTO dto, @MappingTarget ScriptTemplateDAO dao);

    FileContentDAO toEntity(FileContentDTO fileContentDTO);

    FileContentDTO toDto(FileContentDAO fileContentDAO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FileContentDAO partialUpdate(FileContentDTO fileContentDTO, @MappingTarget FileContentDAO fileContentDAO);

    FileContentHistoryDAO toHistoryEntity(FileContentDTO dto);

    FileContentDTO toDto(FileContentHistoryDAO dao);

    HostDAO toEntity(HostDAO hostDAO);

    FileDAO toEntity(FileDTO fileDTO);

    FileDTO toDto(FileDAO fileDAO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FileDAO partialUpdate(FileDTO fileDTO, @MappingTarget FileDAO fileDAO);
}