package org.belon.booktracker.books.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtBooksDto;
import org.belon.booktracker.books.entities.BtBooks;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtBooks and BtBooksDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtBooksMapper {

	public BtBooks BtBooksDtoToBtBooks(BtBooksDto userDto);
	
	public BtBooksDto BtBooksDtoFromBtBooks(BtBooks user);
	
	public List<BtBooks> BtBooksDtoToBtBooks(List<BtBooksDto> userDtos);
	
	public List<BtBooksDto> BtBooksDtoFromBtBooks(List<BtBooks> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtBooks updateBtBooks(BtBooksDto userDto, @MappingTarget BtBooks user);
	
}
