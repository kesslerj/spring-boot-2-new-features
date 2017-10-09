package de.acando.jk.bootdemo.newfeaturesin2.actuator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.DefaultEnablement;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

@Endpoint(id = "person", defaultEnablement = DefaultEnablement.ENABLED)
public class PersonActuatorEndpoint {

	private final Map<String, Person> people = new ConcurrentHashMap<>();

	public PersonActuatorEndpoint() {
		this.people.put("Sheldon", new Person("Sheldon Cooper"));
		this.people.put("Leonard", new Person("Leonard Hofstadter"));
		this.people.put("Penny", new Person("Penny"));
	}

	@ReadOperation
	public List<Person> getAll() {
		return new ArrayList<>(this.people.values());
	}

	@ReadOperation
	public Person getPerson(@Selector String person) {
		return this.people.get(person);
	}

	/*
	 * TODO: mapping "personsName" from json request-body does not work like explained in
	 * https://spring.io/blog/2017/08/22/introducing-actuator-endpoints-in-spring-boot-2-0
	 */
	@WriteOperation
	public void addOrUpdatePerson(@Selector String name, String personsName) {
		this.people.put(name, new Person(personsName));
	}

	public static class Person {
		private String name;

		Person(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
	}
}
