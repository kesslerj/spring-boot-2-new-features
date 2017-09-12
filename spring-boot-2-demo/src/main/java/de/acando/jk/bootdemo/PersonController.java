package de.acando.jk.bootdemo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonRepository repository;

	@PostMapping
	void createSomething(@RequestBody Person body) {
		repository.save(body);
	}

	@GetMapping
	Collection<Person> allPersons() {
		return repository.findAll();
	}

}
