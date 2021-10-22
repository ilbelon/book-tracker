package org.belon.booktracker.books.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.books.api.v1.dtos.BtAuthorDto;
import org.belon.booktracker.books.entities.BtAuthor;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtUser and BtAuthorsDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtAuthorMapper {

	public BtAuthor BtAuthorsDtoToBtAuthors(BtAuthorDto userDto);
	
	public BtAuthorDto BtAuthorsDtoFromBtAuthors(BtAuthor user);
	
	public List<BtAuthor> BtAuthorsDtoToBtAuthors(List<BtAuthorDto> userDtos);
	
	public List<BtAuthorDto> BtAuthorsDtoFromBtAuthors(List<BtAuthor> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtAuthor updateBtAuthors(BtAuthorDto userDto, @MappingTarget BtAuthor user);
	
}
