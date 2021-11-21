package com.systempro.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.domain.Person;
import com.systempro.repositories.PersonRepository;

@Service
public class DBService {

	@Autowired
	private PersonRepository personRepository;



	public void instantiateTestDatabase() {

		Person p1 = new Person(null, "Fernando", "Silva", "54155571056", LocalDate.of(1987, 02, 04));
		p1.getTelefones().add("123123123");
	
		
		personRepository.save(p1);

		
		

	}

}
