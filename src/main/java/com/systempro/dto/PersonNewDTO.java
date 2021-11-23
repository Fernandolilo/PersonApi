package com.systempro.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class PersonNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Size(min= 3, max = 15)
	private String firstName;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Size(min= 3, max = 15)
	private String lastName;
	@CPF
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;
	private LocalDate birthDate;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Size(min= 9, max = 15)
	private String phone;
	private String phoneOne;
	private String phoneTo;

	public PersonNewDTO() {
	}

	public PersonNewDTO(Long id, String firstName, String lastName, String cpf, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneOne() {
		return phoneOne;
	}

	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}

	public String getPhoneTo() {
		return phoneTo;
	}

	public void setPhoneTo(String phoneTo) {
		this.phoneTo = phoneTo;
	}

}
