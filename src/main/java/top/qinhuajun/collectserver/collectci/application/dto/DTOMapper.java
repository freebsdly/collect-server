package top.qinhuajun.collectserver.collectci.application.dto;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import top.qinhuajun.collectserver.collectci.infra.dao.HostDAO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DTOMapper {

    DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

    HostDAO toEntity(HostDTO hostDTO);

    HostDTO toDto(HostDAO host);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    HostDAO partialUpdate(HostDTO hostDTO, @MappingTarget HostDAO host);
}