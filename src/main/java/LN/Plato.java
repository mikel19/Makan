package LN;

import LP.App;

public class Plato {

    private int idPlato;
    private String nombre;
    private float precio;
    private String alergenos;
    private String nombreChef;

    public Plato(String nombre, float precio, String alergenos, String nombreChef) {
        this.idPlato = App.platos.size()+1;
        this.nombre = nombre;
        this.precio = precio;
        this.alergenos = alergenos;
        this.nombreChef = nombreChef;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    public String getNombreChef() {
        return nombreChef;
    }

    public void setNombreChef(String nombreChef) {
        this.nombreChef = nombreChef;
    }
}
