package com.mongo.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.app.entity.Orden;
import com.mongo.app.services.OrdenService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrdenController {
	
	@Autowired private OrdenService ordenService;
	
	@GetMapping("/all")
	public List<Orden> getOrdenes(){		
		return ordenService.getOrdenes();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden guardarOrden(@RequestBody Orden orden) {
		return ordenService.saveOrden(orden);
	}
	
	@GetMapping("/zona/{zona}")
	public List<Orden> getOrderZona(@PathVariable String zona){		
		return ordenService.getOrdenZona(zona);
	}
	
	@GetMapping("{id}")
	public Optional<Orden> getOrden(@PathVariable int id){
		return ordenService.getOrden(id);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Orden updateOrden(@RequestBody Orden orden) {
		Optional<Orden> oOrden = ordenService.getOrden(orden.getId());
		if(oOrden.isPresent()) {
			oOrden.get().setStatus(orden.getStatus());
			return ordenService.saveOrden(oOrden.get());
		}
		return orden;
	}
	
	@GetMapping("/salesman/{id}")
	public List<Orden> findOrdenBySalesmanId(@PathVariable int id){
		return ordenService.findOrdenBySalesmanId(id);
	}
	
	@GetMapping("/state/{status}/{id}")
	public List<Orden> findByStatusAndSalesmanId(@PathVariable String status, @PathVariable int id){
		return ordenService.findByStatusAndSalesmanId(status, id);
	}
	
	@GetMapping("/date/{date}/{id}")
	public List<Orden> findByRegisterdayAndSalesmanId(@PathVariable String date, @PathVariable int id){		
		return ordenService.findByRegisterdayAndSalesmanId(date, id);
	}
	
	
	
	

}
