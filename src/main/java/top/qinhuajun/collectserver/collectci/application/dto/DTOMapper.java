package top.qinhuajun.collectserver.collectci.application.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;
import top.qinhuajun.collectserver.collectci.infra.dao.ScriptTemplateDAO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
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
}