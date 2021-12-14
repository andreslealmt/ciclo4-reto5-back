package com.mongo.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.app.entity.Producto;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, String>{

	
	List<Producto> findByPriceLessThanEqual(double precio);
	
	List<Producto> findByDescriptionLike(String descripcion);
	
	
}
