package com.lgtecnologies.springboot.app.productos.models.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lgtecnologies.springboot.app.commos.models.entity.Producto;

import com.lgtecnologies.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService iproductoService;

	@Autowired
	private Environment env;

	@GetMapping("/listar")
	public List<Producto> listar() {
		return iproductoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto listarPorId(@PathVariable Long id) throws Exception {
		Producto producto = iproductoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));

//		try {
//		Thread.sleep(2000L);
//		}
//		catch (InterruptedException e) {
//		e.printStackTrace();
//		}
		return producto;

	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return iproductoService.save(producto);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDb = iproductoService.findById(id);
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());

		return iproductoService.save(productoDb);

	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		iproductoService.deleteById(id);
	}
}
