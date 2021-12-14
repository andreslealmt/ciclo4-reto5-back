package com.mongo.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.app.entity.Producto;
import com.mongo.app.services.ProductoService;

@RestController
@RequestMapping("/api/accessory")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {
	
	@Autowired private ProductoService productoService;
	
	@GetMapping("/all")
	public List<Producto> getProductos(){
		return productoService.getProductos();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto saveProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}
	
	@GetMapping("/{id}")
	public Optional<Producto> getProducto(@PathVariable String id){
		return productoService.getProducto(id);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto updateProducto(@RequestBody Producto producto) {
		Optional<Producto> oProducto = productoService.getProducto(producto.getReference());
		if(!oProducto.isPresent()) {
			return producto;
		}
		
		oProducto.get().setBrand(producto.getBrand());
		oProducto.get().setCategory(producto.getCategory());
		oProducto.get().setMaterial(producto.getMaterial());
		oProducto.get().setGender(producto.getGender());
		oProducto.get().setSize(producto.getSize());
		oProducto.get().setDescription(producto.getDescription());
		oProducto.get().setAvailability(producto.isAvailability());
		oProducto.get().setPrice(producto.getPrice());
		oProducto.get().setQuantity(producto.getQuantity());
		oProducto.get().setPhotography(producto.getPhotography());
		
		return productoService.saveProducto(oProducto.get());		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProducto(@PathVariable String id) {
		productoService.deleteProducto(id);
	}
	
	@GetMapping("/price/{precio}")
	public List<Producto> filtrarPorPrecio(@PathVariable double precio){
		return productoService.filtrarPorPrecio(precio);
	}
	
	@GetMapping("/description/{descripcion}")
	public List<Producto> filtroDescripcion(@PathVariable String descripcion){
		return productoService.filtroDescripcion(descripcion);
	}
	
	

}
