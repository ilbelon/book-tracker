package org.belon.booktracker.userdata.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtChapterDataDto;
import org.belon.booktracker.userdata.entities.BtChapterData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtChapterDatas and BtChapterDatasDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtChapterDataMapper {

	public BtChapterData btChapterDataDtoToBtChapterData(BtChapterDataDto btChapterDataDto);
	
	public BtChapterDataDto btChapterDataDtoFromBtChapterData(BtChapterData btChapterData);
	
	public List<BtChapterData> btChapterDataDtosToBtChapterDatas(List<BtChapterDataDto> btChapterDataDtos);
	
	public List<BtChapterDataDto> btChapterDataDtosFromBtChapterDatas(List<BtChapterData> btChapterDatas);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtChapterData updateBtChapterData(BtChapterDataDto btChapterDataDto, @MappingTarget BtChapterData btChapterData);
	
}
