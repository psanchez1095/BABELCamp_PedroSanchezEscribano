package entidad.tropas;

import control.Fortaleza;
import entidad.armas.Arma;

public abstract class Tropa implements Runnable{
	
	private String nombre,nombrePlayer;
	private int salud;
	private Arma arma;
	private Fortaleza fortaleza;
	
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
	public String getNombrePlayer() {
		return nombrePlayer;
	}
	public void setNombrePlayer(String nombrePlayer) {
		this.nombrePlayer = nombrePlayer;
	}
	public Fortaleza getFortaleza() {
		return fortaleza;
	}
	public void setFortaleza(Fortaleza fortaleza) {
		this.fortaleza = fortaleza;
	}

	@Override
	public void run() {
		fortaleza.acceder(this);	
	}

	@Override
	public String toString() {
		if(this.getSalud()<=0) this.setSalud(0);
		return "         Tropa "+ nombre + " "+ nombrePlayer + "\n         -salud: " + salud + "\n         -arma: " + arma.getNombre();
	}
	
}
