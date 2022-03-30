package entidad.tropas;

public class Mago extends Tropa {
	
	@Override
	public void atacar(Object o) {
		this.getArma().usar(o);

	}

	public Mago(int salud) {
		super();
	}



}
