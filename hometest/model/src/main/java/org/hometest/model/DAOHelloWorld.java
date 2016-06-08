package org.hometest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jérôme
 */
public class DAOHelloWorld {
	private static DAOHelloWorld instance;
	private String login = "root";
	private String password = "allpriv";
	private String url = "jdbc:mysql://localhost/test";
	
	
	/** DAOHelloWorld est un singleton son constructeur est donc "private" */
	private DAOHelloWorld() { 	
	}
	
	/** 
	 * getInstance() est la seul méthode accessible en static, 
	 * elle est aussi la seul qui peut vous retourner DAOHelloWorld
	 */
	public static DAOHelloWorld getInstance() {
		if(instance == null) {
			instance = new DAOHelloWorld();			
		}
		return instance;		
	}
	
	public String getQuerySelectFirstHelloWorld() {
		String s;		
		try {
			// On ouvre la connexion à la base de données
			Connection connection = DriverManager.getConnection(url, login, password);
			try {
				// On crée un statement.
				Statement st = (Statement) connection.createStatement();
				try {
					// On éxecute la requête.
					ResultSet rs = (ResultSet) st.executeQuery("select * from test");
					try {
						if (rs.next()) {
							s = rs.getString(1);
						} else {
							System.err.println("Il n'y a pas de ligne dans la table 'test'");
							s = null;
						}
					} finally {
						// On ferme la requête , même si il y a une erreur.
						rs.close();
					}
				} finally {
					// On ferme le statement, même si il y a une erreur.
					st.close();
				}
			} finally {
				// On ferme la connexion
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			s = null;
		}
		return s;
	}
}
