package com.lgtecnologies.springboot.app.productos.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lgtecnologies.springboot.app.productos.models.entity.Producto;

import com.lgtecnologies.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService iproductoService;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return iproductoService.findAll().stream().map(producto ->{
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto listarPorId(@PathVariable Long id) throws Exception {
		Producto producto= iproductoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
//		try {
//		Thread.sleep(2000L);
//		}
//		catch (InterruptedException e) {
//		e.printStackTrace();
//		}
		return producto;
	
	}
	
	

}
