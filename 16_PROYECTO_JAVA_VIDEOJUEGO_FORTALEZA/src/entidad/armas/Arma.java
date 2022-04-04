package entidad.armas;

import entidad.tropas.Tropa;

public class Arma {
	
	String nombre;
	int da�o;
	
	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
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
		if ( !ini.equals(o)) ((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDa�o()));
	}
			 
}