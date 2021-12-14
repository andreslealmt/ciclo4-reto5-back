package com.mongo.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.app.entity.Producto;
import com.mongo.app.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired private ProductoRepository productoRepository;
	
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}
	
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public Optional<Producto> getProducto(String id){
		return productoRepository.findById(id);
	}
	
	public void deleteProducto(String id) {
		productoRepository.deleteById(id);
	}
	
	public List<Producto> filtrarPorPrecio(double precio){
		return productoRepository.findByPriceLessThanEqual(precio);
	}
	
	public List<Producto> filtroDescripcion(String descripcion){
		return productoRepository.findByDescriptionLike(descripcion.toUpperCase());
	}

}
