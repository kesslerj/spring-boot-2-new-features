package de.acando.jk.bootdemo.newfeaturesin2.nullable;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping()
	public String hello(@Nullable @RequestParam String name) {
		return "Hello " + name;
	}

}
