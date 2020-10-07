package com.lgtecnologies.springboot.app.productos.models.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lgtecnologies.springboot.app.productos.models.entity.Producto;

import com.lgtecnologies.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService iproductoService;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return iproductoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto listarPorId(@PathVariable Long id) {
		return iproductoService.findById(id);
	}
	
	

}
