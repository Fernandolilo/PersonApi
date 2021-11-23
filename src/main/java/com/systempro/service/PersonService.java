package com.systempro.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.domain.Person;
import com.systempro.dto.PersonDTO;
import com.systempro.dto.PersonNewDTO;
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

	
	@Transactional
	public Person insert (Person obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return obj;
	}
	
	public Person fromDTO(PersonNewDTO objDto) {
		 Person pe = new Person(null, objDto.getFirstName(), objDto.getLastName(), objDto.getCpf(), objDto.getBirthDate());
		 pe.getTelefones().add(objDto.getPhone());
		 if(objDto.getPhoneOne() != null) {
			 pe.getTelefones().add(objDto.getPhoneOne());
		 }
		 if(objDto.getPhoneTo() != null) {
			 pe.getTelefones().add(objDto.getPhoneTo());
		 }
		 return pe;
	}
}
