package org.belon.booktracker.users.services;

import java.util.List;

import org.belon.booktracker.users.api.v1.dtos.BtUserDto;

/**
 * Service interface for BtUsers
 * 
 * @author Andrea
 *
 */

public interface BtUserService {

	public BtUserDto createBtUser(BtUserDto userDto);
	
	public BtUserDto getBtUser(Long id);
	
	public List<BtUserDto> getBtUserList();
	
	public BtUserDto patchBtUser(BtUserDto userDto);
	
	public void deleteBtUser(Long id);
}
