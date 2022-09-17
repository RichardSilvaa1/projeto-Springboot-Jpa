package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.resources.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// operacao que retorna um usario salvo
	public User insert(User obj) {
		return repository.save(obj);
	}

	// busca o usuario no banco por ID e deleta
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}

	// atualiza o usuario do banco
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
