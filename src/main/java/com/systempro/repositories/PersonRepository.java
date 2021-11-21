package com.systempro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
