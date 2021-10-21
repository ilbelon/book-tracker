package org.belon.booktracker.books.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtSettingsDto;
import org.belon.booktracker.books.entities.BtSettings;
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
public interface BtSettingsMapper {

	public BtSettings BtSettingsDtoToBtSettings(BtSettingsDto userDto);
	
	public BtSettingsDto BtSettingsDtoFromBtSettings(BtSettings user);
	
	public List<BtSettings> BtSettingsDtoToBtSettings(List<BtSettingsDto> userDtos);
	
	public List<BtSettingsDto> BtSettingsDtoFromBtSettings(List<BtSettings> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtSettings updateBtSettings(BtSettingsDto userDto, @MappingTarget BtSettings user);
	
}
