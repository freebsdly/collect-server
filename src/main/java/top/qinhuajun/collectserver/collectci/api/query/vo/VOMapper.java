package top.qinhuajun.collectserver.collectci.api.query.vo;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.ScriptTemplateUpdateVO;
import top.qinhuajun.collectserver.collectci.application.dto.*;
import top.qinhuajun.collectserver.common.vo.PageVO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VOMapper {

    VOMapper INSTANCE = Mappers.getMapper(VOMapper.class);

    HostQueryDTO toDTO(HostQueryVO host);

    default <T> PageVO<T> toPageVo(Page<T> page) {
        return new PageVO<>(page.getNumber(), page.getTotalPages(), page.getSize(), page.getTotalElements(), page.getContent());
    }

    default <T> PageVO<T> toPageVo(int current, Page<T> page) {
        return new PageVO<>(current, page.getTotalPages(), page.getSize(), page.getTotalElements(), page.getContent());
    }

    HostDTO toDTO(HostCreateVO vo);

    HostDTO toDTO(HostUpdateVO vo);

    ScriptTemplateQueryDTO toDTO(ScriptTemplateQueryVO vo);

    ScriptTemplateDTO toDTO(ScriptTemplateCreateVO vo);

    ScriptTemplateDTO toDTO(ScriptTemplateUpdateVO vo);

    HostScriptQueryDTO toDTO(HostScriptQueryVO vo);
}
