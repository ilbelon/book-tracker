package org.belon.booktracker.users.api.v1.mappers;

import java.util.List;

import org.belon.booktracker.users.api.v1.dtos.BtUserDto;
import org.belon.booktracker.users.entities.BtUser;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtUser and BtUsersDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_NULL)
public interface BtUserMapper {

	public BtUser btUsersDtoToBtUsers(BtUserDto userDto);
	
	public BtUserDto btUsersDtoFromBtUsers(BtUser user);
	
	public List<BtUser> btUsersDtoToBtUsers(List<BtUserDto> userDtos);
	
	public List<BtUserDto> btUsersDtoFromBtUsers(List<BtUser> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtUser updateBtUsers(BtUserDto userDto, @MappingTarget BtUser user);
	
}
