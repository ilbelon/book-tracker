package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtBookDto;
import org.belon.booktracker.books.entities.BtBook;
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

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_NULL)
public interface BtBookMapper {

	public BtBook BtBooksDtoToBtBooks(BtBookDto bookDto);
	
	public BtBookDto BtBooksDtoFromBtBooks(BtBook book);
	
	public List<BtBook> BtBooksDtoToBtBooks(List<BtBookDto> bookDtos);
	
	public List<BtBookDto> BtBooksDtoFromBtBooks(List<BtBook> books);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtBook updateBtBooks(BtBookDto bookDto, @MappingTarget BtBook book);
	
}
