package org.belon.booktracker.userdata.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.userdata.api.v1.dtos.BtCharacterDataDto;
import org.belon.booktracker.userdata.entities.BtCharacterData;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtCharacterDatas and BtCharacterDatasDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtCharacterDataMapper {

	public BtCharacterData btCharacterDataDtoToBtCharacterData(BtCharacterDataDto btCharacterDataDto);
	
	public BtCharacterDataDto btCharacterDataDtoFromBtCharacterData(BtCharacterData btCharacterData);
	
	public List<BtCharacterData> btCharacterDataDtosToBtCharacterDatas(List<BtCharacterDataDto> btCharacterDataDtos);
	
	public List<BtCharacterDataDto> btCharacterDataDtosFromBtCharacterDatas(List<BtCharacterData> btCharacterDatas);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtCharacterData updateBtCharacterData(BtCharacterDataDto btCharacterDataDto, @MappingTarget BtCharacterData btCharacterData);
	
}
