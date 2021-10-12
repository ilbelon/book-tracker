/**
 * 
 */
package org.belon.booktracker.users.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author andrea
 *
 */
class BtUsersTest {

	BtUsers user = new BtUsers();
	@BeforeEach
	void populateBtUser() {
		user.setId(34L);
		user.setEmail("testemail@email.com");
	}
	/**
	 * Test method for {@link org.belon.booktracker.users.entities.BtUsers#getId()}.
	 */
	@Test
	void testGetId() {
		Long idUser= 34L;
		assertEquals(user.getId(),idUser);
		assertNotEquals(user.getId(), 3L);
	}

	/**
	 * Test method for {@link org.belon.booktracker.users.entities.BtUsers#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		String email="testemail@email.com";
		assertEquals(user.getEmail(),email);
		assertNotEquals(user.getEmail(), "fake");
	}

	/**
	 * Test method for {@link org.belon.booktracker.users.entities.BtUsers#equals(java.lang.Object)}.
	 */
	@Test
	void testEqualsObject() {
		BtUsers user2 = new BtUsers();
		user2.setId(34L);
		user2.setEmail("testemail@email.com");
		assertEquals(user,user2);
	}

}
