package org.belon.booktracker.users.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundExceptions;
import org.belon.booktracker.users.api.v1.dto.BtUsersDto;
import org.belon.booktracker.users.api.v1.mapper.BtUsersMapper;
import org.belon.booktracker.users.entities.BtUsers;
import org.belon.booktracker.users.repositories.BtUsersRepository;
import org.belon.booktracker.users.service.BtUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtUserService
 * 
 * @author Andrea
 *
 */
@Service
public class BtUserServiceImpl implements BtUsersService{

	@Autowired
	private BtUsersRepository userRepository;
	@Autowired
	private BtUsersMapper userMapper;
	
	@Transactional
	public BtUsersDto createBtUser(BtUsersDto userDto) {
		BtUsers user = userMapper.btUsersDtoToBtUsers(userDto);
		user.setRegistrationDate(LocalDateTime.now());
		user = userRepository.save(user);
		return userMapper.btUsersDtoFromBtUsers(user);
	}

	@Transactional(readOnly = true)
	public BtUsersDto getBtUser(Long id) {
		Optional<BtUsers> user = userRepository.findById(id);
		if(user.isPresent()) {
			return userMapper.btUsersDtoFromBtUsers(user.get());
		}
		else throw new ResourceNotFoundExceptions("User with this id does not exists");
	}

	@Transactional(readOnly = true)
	public List<BtUsersDto> getBtUserList() {
		return userMapper.btUsersDtoFromBtUsers(userRepository.findAll());
//		List<BtUsers> userList = userRepository.findAll();
//		if (userList!=null && userList.size()>0) return userMapper.btUsersDtoFromBtUsers(userRepository.findAll());
//		return new ArrayList<BtUsersDto>();
	}

	@Transactional
	public BtUsersDto updateBtUser(BtUsersDto userDto) {
		if(userDto.getId()==null) return null;//TODO trohw invalid format exception
		Optional<BtUsers> user = userRepository.findById(userDto.getId());
		if(user.isPresent()) {
			BtUsers updatedUser = userMapper.updateBtUsers(user.get(), userDto);
			updatedUser = userRepository.save(updatedUser);
			return userMapper.btUsersDtoFromBtUsers(updatedUser);
		}
		else throw new ResourceNotFoundExceptions("User with this id does not exists");
	}

	@Transactional
	public void deleteBtUser(Long id) {
		userRepository.deleteById(id);
	}

}
