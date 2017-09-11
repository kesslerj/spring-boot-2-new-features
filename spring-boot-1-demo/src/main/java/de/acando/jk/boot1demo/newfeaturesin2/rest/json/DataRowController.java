package de.acando.jk.boot1demo.newfeaturesin2.rest.json;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
@RestController("/datarows")
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
