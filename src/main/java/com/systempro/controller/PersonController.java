package com.systempro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Person>> findAll(){
		List<Person> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
