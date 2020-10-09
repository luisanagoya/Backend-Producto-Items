package com.lgtecnologies.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.lgtecnologies.springboot.app.item.clientes.ProductoClienteRest;
import com.lgtecnologies.springboot.app.item.models.Item;
import com.lgtecnologies.springboot.app.commos.models.entity.Producto;

@Service("itemServiceFeing")
@Primary
public class ItemServiceFeing implements IItemService {

	@Autowired
	private ProductoClienteRest clienteFeing;

	@Override
	public List<Item> findAll() {

		return clienteFeing.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {

		return new Item(clienteFeing.listarPorId(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		clienteFeing.crear(producto);
		return null;
	}

	@Override
	public Producto update(Producto producto, Long id) {

		return clienteFeing.editar(producto, id);
	}

	@Override
	public void delete(Long id) {
		clienteFeing.eliminar(id);
	}

}
