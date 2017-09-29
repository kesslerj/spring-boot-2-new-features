package de.acando.jk.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.acando.jk.bootdemo.newfeaturesin2.actuator.PersonActuatorEndpoint;
import de.acando.jk.bootdemo.newfeaturesin2.properties.DemoProperties;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}

	@Bean
	@ConditionalOnEnabledEndpoint
	PersonActuatorEndpoint personEndpoint() {
		return new PersonActuatorEndpoint();
	}

	/*
	 * TODO: add documentation for new security features to reamde
	 *
	 * - security autoconfig completely disabled if custom configuration available
	 *
	 */
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest()
					.permitAll();
		}
	}
}
