package de.acando.jk.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.acando.jk.bootdemo.newfeaturesin2.properties.DemoProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}
}
