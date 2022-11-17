package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	//Simular um id do Banco de Dados
	private final AtomicLong counter = new AtomicLong();

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Alan");
		person.setLastName("JXS");
		person.setAddress("Caucaia - Ceará - Brasil");
		person.setGender("Masculino");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Primeiro Nome" + i);
		person.setLastName("Último Nome" + i);
		person.setAddress("Endereço" + i);
		person.setGender("Gênero" + i);
		return person;
	}
	
	
}
