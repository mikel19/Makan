package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;

import LN.Comanda;
import LN.Menu;
import LN.Plato;
import LN.Reserva;


/**
 * Clase Que interactua con la base de datos llamada test.bd
 * @author Alumno
 *
 */
public class BaseDeDatos {

	private final String RUTABD = "data/Makan" +
			".";
	private Plato plato;
	private Reserva reserva;
	private ArrayList <Plato> list = new ArrayList<Plato>();
	private ArrayList <Reserva> listaReservas = new ArrayList<Reserva>();
	private ArrayList <Menu> listaMenus = new ArrayList<Menu>();
	private Menu menu;
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
	
	/**
	 * Metodo para crear la tabla de reservas
	 */
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
	
	
	/**
	 * Metodo para crear la tabla de menu
	 */
	
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
	                        " PRECIO FLOAT NOT NULL," +
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
	
	/*
	 * Metodo para crear la tabla de platos
	 */
	public void creaciontabla3() {
		 Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE PLATOS " +
	                        "(ID INT  NOT NULL," + 
	                        " NOMBRE TEXT NOT NULL," +
	                         "PRECIO FLOAT NOT NULL," +
	                         "ALERGENOS FLOAT NOT NULL," +
	                        "CHEF TEXT NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	/**
	 * Metodo para crear la tabla de comandas
	 */
	
	public void creaciontabla4() {
		 Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE COMANDAS " +
	                        "(ID INT  NOT NULL," + 
	                        " IDRESERVA INT NOT NULL," +
	                         "PLATOS ARRAYLIST NOT NULL," +
	                         "STRING MENU NOT NULL," +
	                         "FLOAT PRECIOS NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	/**
	 * Metodo para añadir una reserva en la tabla de reservas
	 * @param reserva
	 */
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
	
	/**
	 * Método para añadir comanda en la tabla de comandas
	 * @param comanda
	 */
	public void anadirComandas(Comanda comanda) {
	
		
		Connection c = null;
	      Statement stmt = null;
		 try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "INSERT INTO COMANDAS (IDRESERVA, PLATOS, MENU, PRECIOS) " +
                  "VALUES ('"+comanda.getIdReserva()+"','"+comanda.getPlatos()+"','"+comanda.getNombreM()+"', '"+comanda.getPrecio()+"');";
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
	/**
	 * Metodo para añadir menu en la base de datos
	 * @param menu
	 */

	public void anadirmenu(Menu menu) {
		
		Connection c = null;
	      Statement stmt = null;
		 try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "INSERT INTO MENU (TIPO,PRECIO,PLATO1,PLATO2,PLATO3) " +
                "VALUES ('"+menu.getTipo()+"','"+menu.getPrecio()+"','"+menu.getPlato1()+"','"+menu.getPlato2()+"','"+menu.getPlato3()+"');"; 
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
	
	/**
	 * Metodo para añadir un plato en la base de datos
	 * @param plato
	 */

	public void anadirplatos(Plato plato) {
		
		Connection c = null;
	      Statement stmt = null;
		 try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "INSERT INTO PLATOS (ID,NOMBRE,PRECIO,ALERGENOS,CHEF) " +
                "VALUES ('2','"+plato.getNombre()+"','"+plato.getPrecio()+"','"+plato.getAlergenos()+"','"+plato.getNombreChef()+"');"; 
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
	
	/**
	 * Metodo para conectar con la base de datos
	 * @return
	 */
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
	
	/**
	 * Metodo para obtener resultados de una sentencia SQL
	 * @param sentencia
	 * @return
	 */
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
	
	/**
	 * Metodo para guardar datos a través de una sentencia SQL
	 * @param sentencia
	 */
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
	
	/**
	 * Metodo para leer los datos registrados sobre platos de la base de datos
	 * @return
	 */
	public ArrayList <Plato> leerdatos() {
		list.clear();
		int i=1;
		  
		Connection c = null;
	      Statement stmt = null;
			ResultSet resultados = null;
	      try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    stmt = c.createStatement();
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         resultados = stmt.executeQuery("SELECT NOMBRE, PRECIO, ALERGENOS,CHEF, ID FROM PLATOS;");
	     	while (resultados.next()) {
	     		
			    System.out.println("NOMBRE " + resultados.getString("NOMBRE"));
			   // plato.setNombre(resultados.getString("NOMBRE"));
			   plato=new Plato("",0,"","");
			    plato.setNombreChef(resultados.getString("CHEF"));
			 
			   	plato.setPrecio(resultados.getFloat("PRECIO"));
			   	plato.setAlergenos(resultados.getString("ALERGENOS"));
			    plato.setNombre(resultados.getString("NOMBRE"));
			    list.add(plato);
			 //plato.setNombre(resultados.getString(1));
			   
			   }
	     	resultados.close();
	     	c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return list;
	}
	
	/**
	 * Método para sumar precio de los platos
	 * @return
	 */
	
	public float sumaPlatos() {
		
		int i=1;
		float total=0;
		  
		Connection c = null;
	      Statement stmt = null;
			ResultSet resultados = null;
	      try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    stmt = c.createStatement();
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         resultados = stmt.executeQuery("SELECT PRECIO FROM PLATOS;");
	     	while (resultados.next()) 
	     	{
	     		
			   total=sumar(total,resultados.getFloat("PRECIO"));
			   
			}
	     	resultados.close();
	     	c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(total);
	return total;
	}
	public float sumar(float resultado, float precio)
	{
		resultado += precio;
		
		return resultado;
	}
	
	/**
	 * Metodo para leer las reservas registradas en el sistema
	 * @return
	 */
	
	public ArrayList <Reserva> leerReservas() {
		list.clear();
		int i=1;
		Menu menu;
		  
		Connection c = null;
	      Statement stmt = null;
			ResultSet resultados = null;
	      try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    stmt = c.createStatement();
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         resultados = stmt.executeQuery("SELECT NOMBRE, APELLIDO, FECHA, HORA, TELEFONO, MENU, PERSONAS FROM RESERVAS;");
	     	while (resultados.next()) {
	     		String tipo = resultados.getString("MENU");
	    		menu = new Menu(tipo,20,"","","");
	     			System.out.println("NOMBRE " + resultados.getString("NOMBRE"));
				   // plato.setNombre(resultados.getString("NOMBRE"));
	     			reserva=new Reserva("","","",0,"","",null);
				    reserva.setNombre(resultados.getString("NOMBRE"));
				    reserva.setApellido(resultados.getString("APELLIDO"));
				    reserva.setFecha(resultados.getString("FECHA"));
				    reserva.setHora(resultados.getString("HORA"));
				    reserva.setTelefono(resultados.getString("TELEFONO"));
				    reserva.setNumPersonas(resultados.getInt("PERSONAS"));
				    reserva.setMenu(menu);
	     		
			    listaReservas.add(reserva);
			 //plato.setNombre(resultados.getString(1));
			   
			   }
	     	resultados.close();
	     	c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaReservas;
	     
	
		
	}
	
	/**
	 * Metodo para leer los menus registrados en el sistema
	 * @return
	 */
	public ArrayList <Menu> leerMenus() {
		list.clear();
		int i=1;
		  
		Connection c = null;
	      Statement stmt = null;
			ResultSet resultados = null;
	      try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:test.db");
		    stmt = c.createStatement();
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         resultados = stmt.executeQuery("SELECT TIPO, PRECIO, PLATO1, PLATO2, PLATO3 FROM menu;");
	     	while (resultados.next()) {
	     		
	     			
				   
	     			menu=new Menu("",0,"","","");
	     			menu.setTipo(resultados.getString("TIPO"));
	     			menu.setPrecio(resultados.getFloat("PRECIO"));
	     			menu.setPlato1(resultados.getString("PLATO1"));
	     			menu.setPlato2(resultados.getString("PLATO2"));
				    menu.setPlato3(resultados.getString("PLATO3"));
	     		
			    listaMenus.add(menu);
			 
			   
			   }
	     	resultados.close();
	     	c.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return listaMenus;
	     
	
		
	
	}
	
	/**
	 * Metodo para eliminar una reserva de la base de datos. Se recibe por parametro la reserva que se quiere eliminar
	 * @param reserva
	 */
public void eliminarReserva(Reserva reserva)
{
	Connection c = null;
    Statement stmt = null;
	 try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:test.db");
       c.setAutoCommit(false);
       System.out.println("Opened database successfully");
       stmt = c.createStatement();
       String sql = "DELETE FROM RESERVAS WHERE NOMBRE = '"+reserva.getNombre()+"'";
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

/**
 * Se elimina el menu que se recibe por parametro de la base de datos
 * @param menu
 */
public void eliminarMenu(Menu menu)
{
	Connection c = null;
    Statement stmt = null;
	 try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:test.db");
       c.setAutoCommit(false);
       System.out.println("Opened database successfully");
       stmt = c.createStatement();
       String sql = "DELETE FROM menu WHERE TIPO = '"+menu.getTipo()+"'";
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

/**
 * Se elimina el plato que se recibe como parametro de la base de datos
 * @param plato
 */
public void eliminarPlato(Plato plato)
{
	Connection c = null;
    Statement stmt = null;
	 try {
       Class.forName("org.sqlite.JDBC");
       c = DriverManager.getConnection("jdbc:sqlite:test.db");
       c.setAutoCommit(false);
       System.out.println("Opened database successfully");
       stmt = c.createStatement();
       String sql = "DELETE FROM PLATOS WHERE NOMBRE = '"+plato.getNombre()+"'";
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

/**
 * Metodo para leer todas las comandas registradas en la base de datos
 * @return
 */
public ArrayList<Comanda> leerComandas() {
	list.clear();
	int i=1;
	float a=2;
	Comanda comanda;
	ArrayList<Plato> platos=new ArrayList <Plato>();
	ArrayList <Comanda> comandass= new ArrayList <Comanda>();
	Connection c = null;
      Statement stmt = null;
		ResultSet resultados = null;
      try {
		Class.forName("org.sqlite.JDBC");
	    c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    stmt = c.createStatement();
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         resultados = stmt.executeQuery("SELECT IDRESERVA, PLATOS, MENU, PRECIOS FROM COMANDAS;");
     	while (resultados.next()) {
     		
     		
    		comanda = new Comanda(i,platos,"",a);
     			System.out.println("NOMBRE " + resultados.getString("MENU"));
     			
     			
     			reserva=new Reserva("","","",0,"","",null);
     			
     			comanda.setNombreM(resultados.getString("Menu"));
			    comanda.setPrecio(resultados.getFloat("PRECIOS"));
     			comandass.add(comanda);
     		
		   
		   }
     	resultados.close();
     	c.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return comandass;

}


}