package de.acando.jk.boot1demo.newfeaturesin2.rest.json;

import java.time.LocalDate;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
public class DataRow {

	private String name;
	private LocalDate date;

	public DataRow() {
	}

	public DataRow(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DataRow [name=" + name + ", date=" + date + "]";
	}

}
