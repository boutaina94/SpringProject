package isep.web.sakila.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isep.web.sakila.jpa.entities.Staff;

public interface StaffRepository extends JpaRepository<Staff, Byte> {

	// @Query(value = "SELECT s FROM staff s WHERE s.username='Mike'")
	// public List<Staff> findBySearchTermNative();

	// @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0",
	// nativeQuery = true)
	// List<Staff> findByUsername(String username);

	@Query("select s from Staff s where s.username = ?1 and s.password = ?2")
	Staff findByUsernameByPassword(String username, String password);
}
