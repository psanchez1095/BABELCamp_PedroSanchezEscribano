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

	public void usar(Object ini,Object o) {
		if ( !ini.equals(o)) ((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDa�o()));
	}
			 
}