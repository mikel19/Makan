package LN;

import LP.App;

import java.util.Date;

public class Reserva {

    private int idReserva;
    private String nombre;
    private String apellido;
    private String telefono;
    private int numPersonas;
    private String fecha;
    private String hora;
    private Menu menu;

    public Reserva(String nombre, String apellido, String telefono, int numPersonas, String fecha, String hora, Menu menu) {
        this.idReserva = App.reservas.size()+1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numPersonas = numPersonas;
        this.fecha = fecha;
        this.hora = hora;
        this.menu = menu;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
