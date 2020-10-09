package com.lgtecnologies.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.lgtecnologies.springboot.app.commos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {
	

}
