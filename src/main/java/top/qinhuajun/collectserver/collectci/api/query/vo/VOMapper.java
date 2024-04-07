package top.qinhuajun.collectserver.collectci.api.query.vo;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostCreateVO;
import top.qinhuajun.collectserver.collectci.api.command.vo.HostUpdateVO;
import top.qinhuajun.collectserver.collectci.application.dto.HostDTO;
import top.qinhuajun.collectserver.collectci.application.dto.HostQueryDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VOMapper {

    VOMapper INSTANCE = Mappers.getMapper(VOMapper.class);

    HostQueryDTO toDTO(HostQueryVO host);

    default <T> PageVo<T> toPageVo(Page<T> page) {
        return new PageVo<>(page.getNumber(), page.getTotalPages(), page.getSize(), page.getContent());
    }

    default <T> PageVo<T> toPageVo(int current, Page<T> page) {
        return new PageVo<>(current, page.getTotalPages(), page.getSize(), page.getContent());
    }

    HostDTO toDTO(HostCreateVO vo);
    HostDTO toDTO(HostUpdateVO vo);
}
