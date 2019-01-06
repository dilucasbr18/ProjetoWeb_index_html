package br.com.wagner.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConexaoBD {
  private static Connection con=null;
	
	public static Connection getConexao() {
		
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/FabricaWeb", "postgres", "atletico");
			return con;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
	
	}
	

}
