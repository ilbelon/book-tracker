package org.belon.booktracker.users.repository;

import org.belon.booktracker.users.entities.BtUsers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUsersRepository extends JpaRepository<BtUsers,Long> {

}
