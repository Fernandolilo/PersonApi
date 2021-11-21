package com.systempro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.domain.Person;
import com.systempro.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> findAll() {
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> find(@PathVariable Long id) {
		Person obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
