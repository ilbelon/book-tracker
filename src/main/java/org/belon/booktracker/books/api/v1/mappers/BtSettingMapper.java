package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtSettingDto;
import org.belon.booktracker.books.entities.BtSetting;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtSettings and BtSettingsDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtSettingMapper {

	public BtSetting btSettingsDtoToBtSettings(BtSettingDto userDto);
	
	public BtSettingDto btSettingsDtoFromBtSettings(BtSetting user);
	
	public List<BtSetting> btSettingsDtoToBtSettings(List<BtSettingDto> userDtos);
	
	public List<BtSettingDto> btSettingsDtoFromBtSettings(List<BtSetting> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtSetting updateBtSettings(BtSettingDto userDto, @MappingTarget BtSetting user);
	
}
