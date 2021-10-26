package org.belon.booktracker.users.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.belon.booktracker.core.response.exception.customexceptions.PersistenceViolationException;
import org.belon.booktracker.core.response.exception.customexceptions.ResourceNotFoundException;
import org.belon.booktracker.users.api.v1.dtos.BtUserDto;
import org.belon.booktracker.users.api.v1.mappers.BtUserMapper;
import org.belon.booktracker.users.entities.BtUser;
import org.belon.booktracker.users.repositories.BtUserRepository;
import org.belon.booktracker.users.services.BtUserService;
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
public class BtUserServiceImpl implements BtUserService{

	@Autowired
	private BtUserRepository userRepository;
	@Autowired
	private BtUserMapper userMapper;
	
	private String userNotFoundMessage="User with this id does not exists";
	private String userWithThisUsernameAlreadyExistsMessage="This usernamen already exists.";
	private String userWithThisEmailAlreadyExistsMessage="This email already exists.";
	
	
	@Transactional
	public BtUserDto createBtUser(BtUserDto userDto) {
		this.checkIfAuthorWithUsernameOrEmailAlreadyPresent(userDto);
		BtUser user = userMapper.btUsersDtoToBtUsers(userDto);
		user.setRegistrationDate(LocalDateTime.now());
		user = userRepository.save(user);
		return userMapper.btUsersDtoFromBtUsers(user);
	}

	@Transactional(readOnly = true)
	public BtUserDto getBtUser(Long id) {
		Optional<BtUser> user = userRepository.findById(id);
		if(user.isPresent()) {
			return userMapper.btUsersDtoFromBtUsers(user.get());
		}
		else throw new ResourceNotFoundException(userNotFoundMessage);
	}

	@Transactional(readOnly = true)
	public List<BtUserDto> getBtUserList() {
		return userMapper.btUsersDtoFromBtUsers(userRepository.findAll());
	}

	@Transactional
	public BtUserDto patchBtUser(BtUserDto userDto) {
		this.checkIfAuthorWithUsernameOrEmailAlreadyPresent(userDto);
		Optional<BtUser> user = userRepository.findById(userDto.getId());
		if(user.isPresent()) {
			BtUser updatedUser = userMapper.updateBtUsers(userDto,user.get());
			updatedUser = userRepository.save(updatedUser);
			return userMapper.btUsersDtoFromBtUsers(updatedUser);
		}
		else throw new ResourceNotFoundException(userNotFoundMessage);
	}

	@Transactional
	public void deleteBtUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(userNotFoundMessage);
		}
		
	}
	
	private void checkIfAuthorWithUsernameOrEmailAlreadyPresent(BtUserDto userDto) {
		Optional<BtUser> checkIfAlreadyPresent = userRepository.findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
		if(checkIfAlreadyPresent.isPresent()&&
				(userDto.getId()==null || (userDto.getId()!=null && !userDto.getId().equals(checkIfAlreadyPresent.get().getId())))) {
			BtUser check = checkIfAlreadyPresent.get();
			String errorMessage = userWithThisUsernameAlreadyExistsMessage;
			if(userDto.getEmail().equals(check.getEmail())) errorMessage = userWithThisEmailAlreadyExistsMessage;
			throw new PersistenceViolationException(errorMessage, null); 
		}
	}

}
