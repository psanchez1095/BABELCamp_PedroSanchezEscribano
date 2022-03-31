package entidad.tropas;

import entidad.armas.Rezo;

public class Curandero extends Tropa {

	String armaEspecial = "Libro Sagrado";
	public static String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";

	@Override
	public void atacar(Object o) {

		// Si el arma corresponde con la favorita para el tipo Curandero se aumenta el
		// da�o un 10%
		if (this.getArma() instanceof Rezo) {

			int da�oAct = this.getArma().getDa�o();
			this.getArma().setDa�o(this.getArma().getDa�o() + this.getArma().getDa�o() / 10);

			// Si lleva el arma especial
			if (this.getArma().getNombre().equals(armaEspecial)) {
				this.getArma().setDa�o(this.getArma().getDa�o() + 100);
			}

			this.getArma().usar(o);
			this.getArma().setDa�o(da�oAct);

		} else
			this.getArma().usar(o);

	}

	public Curandero() {
		super();
		this.setNombre("Curandero");
		this.setArma(new Rezo());
		this.getArma().setNombre("Rezo");
	}

	public String paintIcon() {
		String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";
		return icon;
	}

}
