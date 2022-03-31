package entidad.armas;

import entidad.tropas.Tropa;

public class Arma {
	
	String nombre;
	int daño;
	
	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void usar(Object ini,Object o) {
		if ( !ini.equals(o)) ((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDaño()));
	}
			 
}