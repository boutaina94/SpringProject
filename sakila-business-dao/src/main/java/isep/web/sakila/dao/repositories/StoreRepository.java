package isep.web.sakila.dao.repositories;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Byte> {

	// @Query("select s from Store s where s.storeId = ?1")
	// Store findByIdStore(byte id);

}
