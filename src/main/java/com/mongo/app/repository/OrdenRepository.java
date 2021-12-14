package com.mongo.app.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mongo.app.entity.Orden;

@Repository
public interface OrdenRepository extends MongoRepository<Orden, Integer>{

	@Query("{'salesMan.zone': ?0}")
	List<Orden> findByZone(final String zona);
	
	@Query("{'salesMan.id': ?0}")
	List<Orden> findOrdenSalesmanById(final int id);
	
	@Query(value = "{ 'status' : ?0, 'salesMan.id' : ?1 }")
    List<Orden> findByStatusAndSalesmanId(String status, int id);
	
	@Query(value = "{ 'registerDay' : ?0, 'salesMan.id' : ?1 }")
	List<Orden> findByRegisterdayAndSalesmanId(Date date, int id);
	
//	@Query("{'registerDay': ?0}")
//	List<Orden> findByRegisterday(Date date);
	
	
	
//	//@Query("{'orden.status': ?0}")
//	List<Orden> findByStatus(String status);	 
	
//	@Query(value="{ 'status' : ?0 }", fields="{ 'firstname' : 1, 'lastname' : 1}")
//	List<Orden> findByThePersonsFirstname(String firstname);
	
//	
//	@Query("{status: ?0}")
//	List<Orden> findByStatus(final String status);
//	
//	Optional<Orden> findTopByOrdenByIdDesc();
	
}






















