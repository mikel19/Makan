package LP;

import LN.*;
import redis.clients.jedis.Connection;

import java.util.ArrayList;

import LD.BaseDeDatos;

/**
 * Hello world!
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
    	Reserva reserva = null;
    	// datos.creaciontabla();
  
       ventanaPrincipal frame = new ventanaPrincipal();
       frame.setVisible(true);
       frame.lanzarVentana();
       java.sql.Connection c=datos.conectar();
        
    }
}
