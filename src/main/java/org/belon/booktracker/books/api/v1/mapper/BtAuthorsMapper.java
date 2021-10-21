package org.belon.booktracker.books.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.books.api.v1.dto.BtAuthorsDto;
import org.belon.booktracker.books.entities.BtAuthors;
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
public interface BtAuthorsMapper {

	public BtAuthors BtAuthorsDtoToBtAuthors(BtAuthorsDto userDto);
	
	public BtAuthorsDto BtAuthorsDtoFromBtAuthors(BtAuthors user);
	
	public List<BtAuthors> BtAuthorsDtoToBtAuthors(List<BtAuthorsDto> userDtos);
	
	public List<BtAuthorsDto> BtAuthorsDtoFromBtAuthors(List<BtAuthors> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtAuthors updateBtAuthors(BtAuthorsDto userDto, @MappingTarget BtAuthors user);
	
}
