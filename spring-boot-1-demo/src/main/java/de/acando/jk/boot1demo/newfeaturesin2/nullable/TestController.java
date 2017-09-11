package de.acando.jk.boot1demo.newfeaturesin2.nullable;

import java.util.Optional;

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
	 * Nullable geht noch nicht in Spring < 5
	 */
	// @GetMapping()
	// public String hello(@Nullable @RequestParam String name) {
	// return "Hello " + name;
	// }

	/*
	 * Alternative solutions:
	 * - @RequestParam(required = false)
	 * - Optional<String>
	 */
	@GetMapping
	public String hello(@RequestParam Optional<String> name) {
		return "Hello " + name.orElseGet(() -> "unknown");
	}


}
