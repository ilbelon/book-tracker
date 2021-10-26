package org.belon.booktracker.users.repositories;

import java.util.Optional;

import org.belon.booktracker.users.entities.BtUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUserRepository extends JpaRepository<BtUser,Long> {

	public Optional<BtUser> findByUsername(String username);
	
	public Optional<BtUser> findByEmail(String email);
	
	public Optional<BtUser> findByUsernameOrEmail(String username, String email);
	
}
