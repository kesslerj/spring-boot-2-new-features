package de.acando.jk.boot1demo.newfeaturesin2.nullable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
@RestController
@RequestMapping("/test")
public class TestController {

	/*
	 * Alternative solutions for field injection without @Nullable annotation:
	 * - @Autowired(required = false) ServiceWithoutImplementation
	 * - @Autowired Optional<ServiceWithoutImplementation>
	 */
	
	// @Autowired(required = false)
	// private ServiceWithoutImplementation service;

	@Autowired
	private Optional<ServiceWithoutImplementation> service;


	/*
	 * Alternative solution for constructor injection without @Nullable annotation
	 */	
	// private final Optional<ServiceWithoutImplementation> service;
	// public TestController(Optional<ServiceWithoutImplementation> service) {
	// this.service = service;
	// }

	
	
	/*
	 * Nullable annotation not available Spring < 5
	 * Alternative solutions here:
	 * - @RequestParam(required = false) String
	 * - @RequestParam Optional<String>
	 */
	@GetMapping
	public String hello(@RequestParam Optional<String> name) {
		return "Hello " + name.orElse("unknown")
				+ " - "
				+ service.orElse(new ServiceWithoutImplementation() {
				}).tellMeSomething();
	}


}
