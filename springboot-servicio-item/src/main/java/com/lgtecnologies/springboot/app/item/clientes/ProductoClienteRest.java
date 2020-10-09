package com.lgtecnologies.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lgtecnologies.springboot.app.commos.models.entity.Producto;

@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	
	@GetMapping("/ver/{id}")
	public Producto listarPorId(@PathVariable Long id);
	
	@PostMapping("/crear")
	public Producto crear(@RequestBody Producto ptoducto);
	
	@PutMapping("/editar/{id}")
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id);
	
	@DeleteMapping("eliminar/{id}")
	public void eliminar(@PathVariable Long id);
}
