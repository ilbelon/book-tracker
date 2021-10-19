package org.belon.booktracker.users.api.v1.mapper;

import java.util.List;

import org.belon.booktracker.users.api.v1.dto.BtUsersDto;
import org.belon.booktracker.users.entities.BtUsers;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper between BtUser and BtUsersDto
 *
 * @author Andrea
 *
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BtUsersMapper {

	public BtUsers btUsersDtoToBtUsers(BtUsersDto userDto);
	
	public BtUsersDto btUsersDtoFromBtUsers(BtUsers user);
	
	public List<BtUsers> btUsersDtoToBtUsers(List<BtUsersDto> userDtos);
	
	public List<BtUsersDto> btUsersDtoFromBtUsers(List<BtUsers> users);
	
	public BtUsers updateBtUsers(@MappingTarget BtUsers user, BtUsersDto userDto);
	
}
