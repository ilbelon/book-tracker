package org.belon.booktracker.users.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.belon.booktracker.users.dto.BtUsersDto;
import org.belon.booktracker.users.entities.BtUsers;
import org.belon.booktracker.users.mappers.BtUsersMapper;
import org.belon.booktracker.users.repositories.BtUsersRepository;
import org.belon.booktracker.users.service.BtUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service implementations for BtUserService
 * 
 * @author Andrea
 *
 */
@Service
public class BtUserServiceImpl implements BtUserService{

	private BtUsersRepository userRepository;
	
	private BtUsersMapper userMapper;
	
	@Transactional
	public BtUsersDto createBtUser(BtUsersDto userDto) {
		BtUsers user = userMapper.btUsersDtoToBtUsers(userDto);
		user.setRegistrationDate(LocalDate.now());
		user = userRepository.save(user);
		return userMapper.btUsersDtoFromBtUsers(user);
	}

	@Transactional(readOnly = true)
	public BtUsersDto getBtUser(Long id) {
		Optional<BtUsers> user = userRepository.findById(id);
		if(user.isPresent()) {
			return userMapper.btUsersDtoFromBtUsers(user.get());
		}
		return null;//TODO trohw not found exception
	}

	@Transactional(readOnly = true)
	public List<BtUsersDto> getBtUserList() {
		return userMapper.btUsersDtoFromBtUsers(userRepository.findAll());
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
		return null;//TODO trohw not found exception
	}

	@Transactional
	public void deleteBtUser(Long id) {
		userRepository.deleteById(id);
	}

}
