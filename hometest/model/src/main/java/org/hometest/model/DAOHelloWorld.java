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
		// On ouvre la connexion à la base de données
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			// On crée un statement.
			try(Statement st = (Statement) connection.createStatement()) {
				// On éxecute la requête.
				try(ResultSet rs = (ResultSet) st.executeQuery("select * from test")) {										
					if (rs.next()) {
						s = rs.getString(1);
					} else {
						System.err.println("Il n'y a pas de ligne dans la table 'test'");
						s = null;
					}					
				} 
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			s = null;
		}
		return s;
	}
}
