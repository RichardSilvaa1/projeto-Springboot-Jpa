package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//Registrando a Classe como componente do SpringBoot para usar em outra dependencia 
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	// funcao que repassa chamada para o banco exibir os usuarios
	public List<User> findAll() {
		return repository.findAll();
	}

	// funcao que pega usuario por ID
	public User FindById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	// operacao que retorna um usario salvo
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// busca o usuario no banco por ID e deleta
	public void delete (Long id) {
		repository.deleteById(id);
	}

}
