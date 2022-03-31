package entidad.tropas;

import entidad.armas.Arma;

public abstract class Tropa {
	private boolean player;
	private String nombre;
	private int salud;
	private Arma arma;
	

	public abstract void atacar(Object ini,Object o);
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
	public boolean isPlayer() {
		return player;
	}
	public void setPlayer(boolean player) {
		this.player = player;
	}
	
	
}
