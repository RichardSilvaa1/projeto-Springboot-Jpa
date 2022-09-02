package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;

import com.educandoweb.course.repositories.CategoryRepository;

//Registrando a Classe como componente do SpringBoot para usar em outra dependencia 
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// funcao que repassa chamada para o banco exibir as categorias
	public List<Category> findAll() {
		return repository.findAll();
	}

	// funcao que pega a categoria  por ID
	public Category FindById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
