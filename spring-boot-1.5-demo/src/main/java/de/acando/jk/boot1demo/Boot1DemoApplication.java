package de.acando.jk.boot1demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.acando.jk.boot1demo.newfeaturesin2.properties.DemoProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class Boot1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot1DemoApplication.class, args);
	}
}
