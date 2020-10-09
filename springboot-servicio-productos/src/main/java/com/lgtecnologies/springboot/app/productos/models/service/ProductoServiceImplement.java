package com.lgtecnologies.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.lgtecnologies.springboot.app.commos.models.entity.Producto;
import com.lgtecnologies.springboot.app.productos.models.dao.ProductoDao;

@Service
public class ProductoServiceImplement implements IProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional
	public Producto findById(Long id) {

		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		productoDao.save(producto);
		return null;
	}

	
	@Override
	@Transactional
	public Producto update(Producto producto ,Long id) {
		Producto productos= productoDao.findById(id).orElse(null);
		productos.setNombre(producto.getNombre());
		productos.setPrecio(producto.getPrecio());
		return productoDao.save(productos);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
