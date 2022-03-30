package entidad.armas;

import entidad.tropas.Tropa;

public class Arma {
	
	int daño;
	
	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public void usar(Object o) {
	((Tropa) o).setSalud(((Tropa) o).getSalud()+this.getDaño());
	}
}