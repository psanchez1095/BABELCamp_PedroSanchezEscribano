package entidad.tropas;

import entidad.armas.Arma;

public abstract class Tropa {
	
	private String nombre;
	private int salud;
	private Arma arma;
	

	public abstract void atacar(Object o);
	public abstract String paintIcon();

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
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
