package entidad.tropas;

import control.Fortaleza;
import entidad.armas.Rezo;

public class Curandero extends Tropa {

	String armaEspecial = "Libro Sagrado";
	private int da�oExtraArmaEspecial;
	public static String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";

	public Curandero() {
		super();
		this.setNombre("Curandero");
		this.setArma(new Rezo());
		this.getArma().setNombre("Rezo");
		this.setDa�oExtraArmaEspecial(100);
	}
	public Curandero(Fortaleza fortaleza) {
		super();
		this.setNombre("Curandero");
		this.setArma(new Rezo());
		this.getArma().setNombre("Rezo");
		this.setDa�oExtraArmaEspecial(100);
		this.setFortaleza(fortaleza);
	}
	
	@Override
	public void atacar(Object ini,Object o) {

		// Si el arma corresponde con la favorita para el tipo Curandero se aumenta el
		// da�o un 10%
		if (this.getArma() instanceof Rezo) {

			int da�oAct = this.getArma().getDa�o();
			this.getArma().setDa�o(this.getArma().getDa�o() + this.getArma().getDa�o() / 10);

			// Si lleva el arma especial
			if (this.getArma().getNombre().equals(armaEspecial)) {
				this.getArma().setDa�o(this.getArma().getDa�o() + this.getDa�oExtraArmaEspecial());
			}

			this.getArma().usar(ini,o);
			this.getArma().setDa�o(da�oAct);

		} else
			this.getArma().usar(ini,o);

	}

	public int getDa�oExtraArmaEspecial() {
		return da�oExtraArmaEspecial;
	}

	public void setDa�oExtraArmaEspecial(int da�oExtraArmaEspecial) {
		this.da�oExtraArmaEspecial = da�oExtraArmaEspecial;
	}

	public String paintIcon() {
		String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";
		return icon;
	}

}
