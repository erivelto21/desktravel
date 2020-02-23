package br.com.desktravel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(){
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//			return DriverManager.getConnection(
//					"jdbc:mysql://localhost/deskTravel", "root", "root123");
			return DriverManager.getConnection(
					"jdbc:mysql://db4free.net/desk_travel", "desktravel", "d3sktr4v3l");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
