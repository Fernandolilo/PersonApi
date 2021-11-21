package com.systempro.service;

import java.util.List;
import java.util.Optional;

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
	
	public Person find(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new com.systempro.service.exception.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + ", Tipo: " + Person.class.getName()));
	}

}
