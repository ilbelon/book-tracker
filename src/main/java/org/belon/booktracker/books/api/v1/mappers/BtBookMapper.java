package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;
import org.belon.booktracker.books.entities.BtBook;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_NULL)
public interface BtBookMapper {

	public BtBook btBooksDtoToBtBooks(BtBookDto bookDto);
	
	@Mapping(target = "bookSerieNumber.book", ignore = true)
	public BtBookDto btBooksDtoFromBtBooks(BtBook book);
	
	public List<BtBook> btBooksDtoToBtBooks(List<BtBookDto> bookDtos);
	
	public List<BtBookDto> btBooksDtoFromBtBooks(List<BtBook> books);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtBook updateBtBooks(BtBookDto bookDto, @MappingTarget BtBook book);
	
}
