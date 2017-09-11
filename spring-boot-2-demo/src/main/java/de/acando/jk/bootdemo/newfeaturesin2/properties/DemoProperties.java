package de.acando.jk.bootdemo.newfeaturesin2.properties;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/*
 * @Valiadated is now required, if there are any validation annotations which should be requested at startup.
 */
@Validated
@ConfigurationProperties(prefix = "test")
public class DemoProperties {

	@NotNull
	private String any;

	public String getAny() {
		return any;
	}

	public void setAny(String any) {
		this.any = any;
	}

}
