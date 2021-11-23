package com.systempro.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.systempro.domain.Person;
import com.systempro.dto.PersonNewDTO;
import com.systempro.repositories.PersonRepository;
import com.systempro.service.exception.DataIntegrityException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person find(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new com.systempro.service.exception.ObjectNotFoundException(
				"Objeto não encontrado! ID: " + ", Tipo: " + Person.class.getName()));
	}

	@Transactional
	public Person insert(Person obj) {
		obj.setId(null);
		obj = repository.save(obj);
		return obj;
	}

	// Aux of insert new Person
	public Person fromDTO(PersonNewDTO objDto) {
		Person pe = new Person(null, objDto.getFirstName(), objDto.getLastName(), objDto.getCpf(),
				objDto.getBirthDate());
		pe.getPhones().add(objDto.getPhone());
		if (objDto.getPhoneOne() != null) {
			pe.getPhones().add(objDto.getPhoneOne());
		}
		if (objDto.getPhoneTo() != null) {
			pe.getPhones().add(objDto.getPhoneTo());
		}
		return pe;
	}

	public Person update(Person obj) {
		Person newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	// aux update
	private void updateData(Person newObj, Person obj) {
		newObj.setPhones(obj.getPhones());
	}

	public void delete(Long id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir este ID");
		}

	}
}
