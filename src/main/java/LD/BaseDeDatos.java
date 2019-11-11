package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {

	private final String RUTABD = "data/Makan" +
			".";
	
	public  void conexion() {
		Connection c = null;
		System.out.println("fff");
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}
	
	public void creaciontabla() {
		 Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE reservas " +
	                        "(ID INT PRIMARY KEY     NOT NULL," +
	                        " NOMBRE           TEXT    NOT NULL, " + 
	                        " APELLIDO         TEXT     NOT NULL, " + 
	                        " FECHA        	TEXT			 " + 
	                        " TELEFONO 		TEXT      NOT NULL,"+
	                        " HORA          TEXT     NOT NULL,"+
	                        " MENU          TEXT NOT NULL,"+
	                        " PERSONAS TEXT NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	public void anadirdatos(int ID, String NOMBRE, String APELLIDO, String FECHA, String HORA, String Menu, String Personas) {
		
		Connection c = null;
	      Statement stmt = null;
		 try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
//lo de abajo da error
	         stmt = c.createStatement();
	         String sql = "INSERT INTO reservas" +
	                        "VALUES ('"+ID+"', '"+NOMBRE+"', '"+APELLIDO+"', '"+FECHA+"', '"+HORA+"', '"+Menu+"','"+Personas+"')"; 
      stmt.executeUpdate(sql);
//
	       //  String sql = "INSERT INTO RESERVAS (ID,NOMBRE,APELLIDO,FECHA,HORA,MENU,PERSONAS) " +
	         //         "VALUES (ID, '"+NOMBRE+"', '"+APELLIDO+"', '"+FECHA+"', '"+HORA+"', '"+Menu+"','"+Personas+"')";7
	         //SOLUCIONAR LO QUE ESTA ABAJO
	     
//
//	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//	                  "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
//	         stmt.executeUpdate(sql);
//
//	         sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//	                  "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
//	         stmt.executeUpdate(sql);
//
//	         stmt.close();
//	         c.commit();
//	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
		
		
		
		
		
	}

	public Connection conectar(){
		try{
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:sqlite:"+RUTABD);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public ResultSet obtenerDatos(String sentencia){
		Connection conn = conectar();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;
	}
	public void guardarDatos(String sentencia){
		Connection conn = conectar();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.executeUpdate(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}