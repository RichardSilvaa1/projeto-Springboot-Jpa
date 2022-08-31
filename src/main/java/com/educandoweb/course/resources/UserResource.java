package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

	//metodo que responde a requisicao
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u1 = new User(1L,"Maria", "Mari@gmail.com", "51993675858", "1234");
		User u2 = new User(2L,"CARLOS", "Carlos@gmail.com", "51993675858", "1234");
		System.out.println("TESTE CONCLUIDO");
		//retornar a resposta com sucesso 
		return ResponseEntity.ok().body(u1);
	}
	
}
