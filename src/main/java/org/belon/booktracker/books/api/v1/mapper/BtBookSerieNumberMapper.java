package org.belon.booktracker.books.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtBookSerieNumberDto;
import org.belon.booktracker.books.entities.BtBookSerieNumber;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtBookSerieNumber and BtBookSerieNumberDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtBookSerieNumberMapper {

	public BtBookSerieNumber BtBookSerieNumberDtoToBtBookSerieNumber(BtBookSerieNumberDto userDto);
	
	public BtBookSerieNumberDto BtBookSerieNumberDtoFromBtBookSerieNumber(BtBookSerieNumber user);
	
	public List<BtBookSerieNumber> BtBookSerieNumberDtoToBtBookSerieNumber(List<BtBookSerieNumberDto> userDtos);
	
	public List<BtBookSerieNumberDto> BtBookSerieNumberDtoFromBtBookSerieNumber(List<BtBookSerieNumber> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtBookSerieNumber updateBtBookSerieNumber(BtBookSerieNumberDto userDto, @MappingTarget BtBookSerieNumber user);
	
}
