package LN;

import LP.App;

import java.util.ArrayList;

public class Menu {

    private int idMenu;
    private String tipo;
    private float precio;
    private String plato1;
    private String plato2;
    private String plato3;
  

    public Menu(String tipo, float precio, String plato1, String plato2, String plato3) {
        this.idMenu = App.menus.size()+1;
        this.tipo = tipo;
        this.precio = precio;
        this.plato1=plato1;
        this.plato2=plato2;
        this.plato3=plato3;
   
    }

    public String getPlato1() {
		return plato1;
	}

	public void setPlato1(String plato1) {
		this.plato1 = plato1;
	}

	public String getPlato2() {
		return plato2;
	}

	public void setPlato2(String plato2) {
		this.plato2 = plato2;
	}

	public String getPlato3() {
		return plato3;
	}

	public void setPlato3(String plato3) {
		this.plato3 = plato3;
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

 
}
