package entidad.tropas;

import entidad.armas.Arma;

public abstract class Tropa {
	
	private int salud;
	private Arma arma;
	
	public abstract void atacar();

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
}
