package com.lgtecnologies.springboot.app.productos.models.service;

import java.util.List;

import com.lgtecnologies.springboot.app.commos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
	
	public Producto update(Producto producto, Long id);
	
	

}
