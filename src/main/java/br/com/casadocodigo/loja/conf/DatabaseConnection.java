package br.com.casadocodigo.loja.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection con;
	private String url = "jdbc:mysql://localhost/estoque?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String pass = "";
	//private String url = "127.0.0.1";
	//private String user = "azure";
	//private String pass = "6#vWHD_$";

	private static DatabaseConnection instancia = null;

	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseConnection getInstance() {
		if (instancia == null) {
			instancia = new DatabaseConnection();
		}
		return instancia;
	}

	public Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, user, pass);
		}
		return con;
	}
}
