package entidad.armas;

import entidad.tropas.Tropa;

public class Arma {
	
	int da�o;
	
	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public void usar(Object o) {
	((Tropa) o).setSalud(((Tropa) o).getSalud()+this.getDa�o());
	}
}