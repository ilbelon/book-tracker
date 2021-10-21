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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtUserService
 * 
 * @author Andrea
 *
 */
@Service
public class BtUsersServiceImpl implements BtUsersService{

	@Autowired
	private BtUsersRepository userRepository;
	@Autowired
	private BtUsersMapper userMapper;
	
	private String userNotFoundMessage="User with this id does not exists";
	
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
		else throw new ResourceNotFoundExceptions(userNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtUsersDto> getBtUserList() {
		return userMapper.btUsersDtoFromBtUsers(userRepository.findAll());
	}

	@Transactional
	public BtUsersDto patchBtUser(BtUsersDto userDto) {
		if(userDto.getId()==null) return null;
		Optional<BtUsers> user = userRepository.findById(userDto.getId());
		if(user.isPresent()) {
			BtUsers updatedUser = userMapper.updateBtUsers(userDto,user.get());
			updatedUser = userRepository.save(updatedUser);
			return userMapper.btUsersDtoFromBtUsers(updatedUser);
		}
		else throw new ResourceNotFoundExceptions(userNotFoundMessage);
	}

	@Transactional
	public void deleteBtUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundExceptions(userNotFoundMessage);
		}
		
	}

}
