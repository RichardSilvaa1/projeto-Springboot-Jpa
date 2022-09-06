package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//Registrando a Classe como componente do SpringBoot para usar em outra dependencia 
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	// funcao que repassa chamada para o banco exibir as categorias
	public List<Product> findAll() {
		return repository.findAll();
	}

	// funcao que pega a categoria  por ID
	public Product FindById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
