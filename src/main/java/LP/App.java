package LP;

import LN.*;

import java.util.ArrayList;

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
        System.out.println( "Hello World!" );
        ventanaPrincipal frame = new ventanaPrincipal();
        frame.setVisible(true);
        //frame.lanzarVentana();
    }
}
