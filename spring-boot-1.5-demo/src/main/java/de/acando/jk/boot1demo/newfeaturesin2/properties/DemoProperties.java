package de.acando.jk.boot1demo.newfeaturesin2.properties;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
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
