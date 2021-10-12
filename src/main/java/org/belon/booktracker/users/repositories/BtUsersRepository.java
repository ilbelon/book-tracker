package org.belon.booktracker.users.repositories;

import org.belon.booktracker.users.entities.BtUsers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUsersRepository extends JpaRepository<BtUsers,Long> {

}
