package LN;

import LD.BaseDeDatos;
import LP.App;
import java.util.Date;

public class Gestor {

    BaseDeDatos datos = new BaseDeDatos();

    public Reserva crearReserva(String nombre, String apellidos, String telefono, int numPersonas, Date fecha, String hora, Menu menu){
        Reserva nuevaReserva = new Reserva(nombre, apellidos, telefono, numPersonas, fecha, hora, menu);
        App.reservas.add(nuevaReserva);
        return nuevaReserva;
    }
    public Plato crearPlato(String nombre, float precio, String alergenos, String nombreChef){
        Plato nuevoPlato = new Plato(nombre, precio, alergenos, nombreChef);
        App.platos.add(nuevoPlato);
        return nuevoPlato;
    }
    public Comanda crearComanda(int idReserva){
        Comanda nuevaComanda = new Comanda(idReserva);
        App.comandas.add(nuevaComanda);
        return nuevaComanda;
    }
    public Menu crearMenu(String tipo, float precio){
        Menu nuevoMenu = new Menu(tipo, precio);
        App.menus.add(nuevoMenu);
        return nuevoMenu;
    }
    public void addComanda(Plato plato, int idComanda){
        for (int i=0; i<App.comandas.size(); i++){
            if (App.comandas.get(i).getIdComanda() == idComanda){
                App.comandas.get(i).getPlatos().add(plato);
            }
        }
    }
    public void addMenu(Plato plato, int idMenu){
        for (int i=0; i<App.menus.size(); i++){
            if (App.menus.get(i).getIdMenu() == idMenu){
                App.menus.get(i).getPlatos().add(plato);
            }
        }
    }

}
