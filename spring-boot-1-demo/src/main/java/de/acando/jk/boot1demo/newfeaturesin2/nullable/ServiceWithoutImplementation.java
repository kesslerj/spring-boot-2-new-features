package de.acando.jk.boot1demo.newfeaturesin2.nullable;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
public interface ServiceWithoutImplementation {

	public default String tellMeSomething() {
		return "Spring is awesome";
	}
}
