package entidad.tropas;

public class Curandero extends Tropa {

	@Override
	public void atacar(Object o) {
		this.getArma().usar(o);
	}

	public Curandero() {
		super();
		// TODO Auto-generated constructor stub
	}


}
