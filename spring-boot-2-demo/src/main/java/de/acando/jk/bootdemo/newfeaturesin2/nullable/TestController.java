package de.acando.jk.bootdemo.newfeaturesin2.nullable;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	/*
	 * @Nullable usage at field injection
	 */
	// @Nullable
	// @Autowired
	// private ServiceWithoutImplementation service;


	/*
	 * @Nullable usage in constructor injection
	 *
	 * FYI, since spring 4.3:
	 *  ->  It is no longer necessary to specify the @Autowired annotation if the target bean only defines one constructor.
	 *  compare https://docs.spring.io/spring/docs/current/spring-framework-reference/html/new-in-4.3.html
	 */
	private final ServiceWithoutImplementation service;
	public TestController(@Nullable ServiceWithoutImplementation service) {
		this.service = service;
	}

	@GetMapping()
	public String hello(@Nullable @RequestParam String name) {
		return "Hello " + Optional.ofNullable(name).orElse("unknown")
				+ " - "
				+ Optional.ofNullable(service)
						.orElse(new ServiceWithoutImplementation() {
				}).tellMeSomething();
	}

}
