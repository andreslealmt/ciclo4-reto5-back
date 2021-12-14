package com.mongo.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.app.entity.Orden;
import com.mongo.app.repository.OrdenRepository;

@Service
public class OrdenService {

	@Autowired private OrdenRepository ordenRepository;
	
	public List<Orden> getOrdenes(){		
		return ordenRepository.findAll();
	}
	
	public Orden saveOrden(Orden orden) {
		return ordenRepository.save(orden);
	}
	
	public List<Orden> getOrdenZona(String zona){
		return ordenRepository.findByZone(zona);
	}
	
	public Optional<Orden> getOrden(int id){
		return ordenRepository.findById(id);
	}
	
	public List<Orden> findOrdenBySalesmanId(int id){
		return ordenRepository.findOrdenSalesmanById(id);
	}
	
	public List<Orden> findByStatusAndSalesmanId(String status, int id){
		return ordenRepository.findByStatusAndSalesmanId(status, id);
	}	
	
	public List<Orden> findByRegisterdayAndSalesmanId(String date, int id){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormateada = null;
		try {
			dataFormateada = formato.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordenRepository.findByRegisterdayAndSalesmanId(dataFormateada, id);
	}
	

	
}





