package org.belon.booktracker.users.repositories;

import org.belon.booktracker.users.entities.BtUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author andrea
 *
 */
public interface BtUserRepository extends JpaRepository<BtUser,Long> {

}
