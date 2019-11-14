package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import LN.Reserva;

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
	                        "(NOMBRE TEXT  NOT NULL," + 
	                        " APELLIDO TEXT NOT NULL," +
	                         "FECHA TEXT NOT NULL," +
	                         "TELEFONO TEXT NOT NULL," +
	                        "HORA TEXT NOT NULL,"+
	                         "MENU TEXT NOT NULL,"+
	                        "PERSONAS INT NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	public void creaciontabla2() {
		 Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE menu " +
	                        "(TIPO TEXT  NOT NULL," + 
	                        " PRECIO INT NOT NULL," +
	                         "PLATO1 TEXT NOT NULL," +
	                         "PLATO2 TEXT NOT NULL," +
	                        "PLATO3 TEXT NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	public void anadirdatosreserva(Reserva reserva) {
	
		
		Connection c = null;
	      Statement stmt = null;
		 try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "INSERT INTO RESERVAS (NOMBRE,APELLIDO,FECHA,TELEFONO,HORA,MENU,PERSONAS) " +
                  "VALUES ('"+reserva.getNombre()+"','"+reserva.getApellido()+"','"+reserva.getFecha()+"','"+reserva.getTelefono()+"','"+reserva.getHora()+"','"+reserva.getMenu().getTipo()+"','"+reserva.getNumPersonas()+"');"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
		      c.commit();
		      c.close();
		  } catch ( Exception e ) {
		         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		         System.exit(0);
		      }
		      System.out.println("Records created successfully");
	         
	         
	}
		
//public ResultSet consultar(String sql){
//	
//	Connection c = null;
//      Reserva stmt = null;
// ResultSet resultado = null;
// try {
//  resultado = rR.executeQuery(sql);
// }catch (SQLException e) {
//  JOptionPane.showMessageDialog(null, ""+e.getMessage());
// }
//  return resultado;
//}
	
	
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