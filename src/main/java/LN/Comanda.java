package LN;

import LP.App;

import java.util.ArrayList;

public class Comanda {

    private int idComanda;
    private int idReserva;
    private ArrayList<Plato> platos;
    private Menu menu;

    public Comanda(int idReserva) {
        this.idComanda = App.comandas.size()+1;
        this.idReserva = idReserva;
        this.platos = new ArrayList<Plato>();
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
