package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtBookSerieNumberDto;
import org.belon.booktracker.books.entities.BtBookSerieNumber;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

	public BtBookSerieNumber btBookSerieNumberDtoToBtBookSerieNumber(BtBookSerieNumberDto userDto);
	
	@Mapping(target = "book.bookSerieNumber", ignore = true)
	public BtBookSerieNumberDto btBookSerieNumberDtoFromBtBookSerieNumber(BtBookSerieNumber user);
	
	public List<BtBookSerieNumber> btBookSerieNumberDtoToBtBookSerieNumber(List<BtBookSerieNumberDto> userDtos);
	
	public List<BtBookSerieNumberDto> btBookSerieNumberDtoFromBtBookSerieNumber(List<BtBookSerieNumber> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtBookSerieNumber updateBtBookSerieNumber(BtBookSerieNumberDto userDto, @MappingTarget BtBookSerieNumber user);
	
}
