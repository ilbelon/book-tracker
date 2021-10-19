/**
 * 
 */
package org.belon.booktracker.users.service;

import java.util.List;

import org.belon.booktracker.users.dto.BtUsersDto;

/**
 * Service interface for BtUsers
 * 
 * @author Andrea
 *
 */

public interface BtUserService {

	public BtUsersDto createBtUser(BtUsersDto userDto);
	
	public BtUsersDto getBtUser(Long id);
	
	public List<BtUsersDto> getBtUserList();
	
	public BtUsersDto updateBtUser(BtUsersDto userDto);
	
	public void deleteBtUser(Long id);
}
