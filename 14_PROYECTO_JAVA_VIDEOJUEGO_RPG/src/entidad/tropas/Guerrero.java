package entidad.tropas;

public class Guerrero extends Tropa {

	@Override
	public void atacar(Object o) {
		this.getArma().usar(o);
	}

	public Guerrero() {
		super();
		// TODO Auto-generated constructor stub
	}

}
