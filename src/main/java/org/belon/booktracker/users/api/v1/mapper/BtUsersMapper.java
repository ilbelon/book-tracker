package org.belon.booktracker.users.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.users.api.v1.dto.BtUsersDto;
import org.belon.booktracker.users.entities.BtUsers;
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

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface BtUsersMapper {

	public BtUsers btUsersDtoToBtUsers(BtUsersDto userDto);
	
	public BtUsersDto btUsersDtoFromBtUsers(BtUsers user);
	
	public List<BtUsers> btUsersDtoToBtUsers(List<BtUsersDto> userDtos);
	
	public List<BtUsersDto> btUsersDtoFromBtUsers(List<BtUsers> users);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	public BtUsers updateBtUsers(BtUsersDto userDto, @MappingTarget BtUsers user);
	
}
