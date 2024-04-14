package top.qinhuajun.collectserver.collectci.api.query;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import top.qinhuajun.collectserver.collectci.application.dto.FileQueryDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostScriptQueryDTO;
import top.qinhuajun.collectserver.collectci.application.dto.ScriptTemplateQueryDTO;
import top.qinhuajun.collectserver.common.api.PageMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QueryApiMapper extends PageMapper {

    QueryApiMapper INSTANCE = Mappers.getMapper(QueryApiMapper.class);

    HostQueryDTO toDTO(HostQueryOptions host);

    HostScriptQueryDTO toDTO(HostScriptQueryOptions vo);

    FileQueryDTO toDTO(FileQueryOptions vo);

    ScriptTemplateQueryDTO toDTO(ScriptTemplateQueryOptions query);

}
