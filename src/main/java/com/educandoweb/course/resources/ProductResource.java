package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;

import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	// dependencia para o service
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> FindAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

// requisicao busca usuario por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.FindById(id);
		return ResponseEntity.ok().body(obj);
	}
}
