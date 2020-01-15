package LP;

import LN.*;
import redis.clients.jedis.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import LD.BaseDeDatos;

/**
 * Metodo inicial para lanzar la aplicacion
 *
 */
public class App 
{
    public static ArrayList<Comanda> comandas = new ArrayList<Comanda>();
    public static ArrayList<Menu> menus = new ArrayList<Menu>();
    public static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    public static ArrayList<Plato> platos = new ArrayList<Plato>();

    public static void main( String[] args )
    {
    	BaseDeDatos datos=new BaseDeDatos();
    	//datos.leerdatos();
    	//datos.creaciontabla();
    	//datos.creaciontabla2();
    	//datos.creaciontabla3();
  
       ventanaPrincipal frame = new ventanaPrincipal();
       //frame.setVisible(true);
       frame.lanzarVentana();
       java.sql.Connection c=datos.conectar();
     
        
    }
}
