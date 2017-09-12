package de.acando.jk.bootdemo.newfeaturesin2.rest.json;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Spring-boot v2.0.0 comes with a new spring-boot-starter-json, which includes some dependencies
 * which we always has do declare, e.g. jackson-databind and jackson-datatype-jsr310 for convenient handling of Java 8 date types.
 */
@RestController
@RequestMapping("/datarows")
public class DataRowController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public DataRow getDataRow() {
		return new DataRow("any", LocalDate.now());
	}

	@PostMapping
	public void postDataRow(@RequestBody DataRow data) {
		System.out.println("POST: " + data);
	}
}
