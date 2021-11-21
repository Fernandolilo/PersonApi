package com.systempro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.domain.Person;
import com.systempro.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}

}
