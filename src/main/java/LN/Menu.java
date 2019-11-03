package LN;

import LP.App;

import java.util.ArrayList;

public class Menu {

    private int idMenu;
    private String tipo;
    private float precio;
    private ArrayList<Plato> platos;

    public Menu(String tipo, float precio) {
        this.idMenu = App.menus.size()+1;
        this.tipo = tipo;
        this.precio = precio;
        this.platos = new ArrayList<Plato>();
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }
}
