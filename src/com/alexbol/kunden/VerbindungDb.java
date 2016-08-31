package com.alexbol.kunden;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class VerbindungDb {
	private static Connection cn;

	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Properties propiedades = new Properties();
			InputStream entrada = null;
			entrada = new FileInputStream("configuracion.properties");
			// cargamos el archivo de propiedades
			propiedades.load(entrada);
			String userSQL = propiedades.getProperty("usuario");
			String passSQL = propiedades.getProperty("password");
			String conURL = "jdbc:sqlserver://localhost:1433;databaseName=geschaeft;user=" + userSQL + ";password="+ passSQL + "";
			cn = DriverManager.getConnection(conURL);
		} catch (Exception ex) {
			System.out.println(ex);
			cn = null;
		}
		return cn;
	}
}
