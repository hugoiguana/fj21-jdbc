package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	public Connection getConection() {

		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/fj21", "postgres", "admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
