package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;

import com.educandoweb.course.repositories.OrderRepository;

//Registrando a Classe como componente do SpringBoot para usar em outra dependencia 
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	// funcao que repassa chamada para o banco exibir os pedidos
	public List<Order> findAll() {
		return repository.findAll();
	}

	// funcao que pega o pedido por ID
	public Order FindById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
