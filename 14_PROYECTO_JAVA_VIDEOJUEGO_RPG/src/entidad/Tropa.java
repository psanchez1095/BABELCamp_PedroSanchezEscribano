package entidad;

public abstract class Tropa {
	
	private int salud;
	private Arma arma;
	
	public abstract void atacar();
	public abstract void defenderse();
}
