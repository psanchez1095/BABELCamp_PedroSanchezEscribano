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

	/**
	 * Metodo que se encarga de usar el arma
	 * @param ini es la tropa que inicia la accion con el arma 
	 * @param o es la tropa que recibe la accion con el arma 
	 */
	public void usar(Object ini,Object o) {
		if ( !ini.equals(o)) ((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDaño()));
	}
			 
}