package entidad.tropas;

import control.Fortaleza;
import entidad.armas.Rezo;

public class Curandero extends Tropa {

	String armaEspecial = "Libro Sagrado";
	private int dañoExtraArmaEspecial;
	public static String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";

	public Curandero() {
		super();
		this.setNombre("Curandero");
		this.setArma(new Rezo());
		this.getArma().setNombre("Rezo");
		this.setDañoExtraArmaEspecial(100);
	}
	public Curandero(Fortaleza fortaleza) {
		super();
		this.setNombre("Curandero");
		this.setArma(new Rezo());
		this.getArma().setNombre("Rezo");
		this.setDañoExtraArmaEspecial(100);
		this.setFortaleza(fortaleza);
	}
	
	@Override
	public void atacar(Object ini,Object o) {

		// Si el arma corresponde con la favorita para el tipo Curandero se aumenta el
		// daño un 10%
		if (this.getArma() instanceof Rezo) {

			int dañoAct = this.getArma().getDaño();
			this.getArma().setDaño(this.getArma().getDaño() + this.getArma().getDaño() / 10);

			// Si lleva el arma especial
			if (this.getArma().getNombre().equals(armaEspecial)) {
				this.getArma().setDaño(this.getArma().getDaño() + this.getDañoExtraArmaEspecial());
			}

			this.getArma().usar(ini,o);
			this.getArma().setDaño(dañoAct);

		} else
			this.getArma().usar(ini,o);

	}

	public int getDañoExtraArmaEspecial() {
		return dañoExtraArmaEspecial;
	}

	public void setDañoExtraArmaEspecial(int dañoExtraArmaEspecial) {
		this.dañoExtraArmaEspecial = dañoExtraArmaEspecial;
	}

	public String paintIcon() {
		String icon = "   ___|___  \n    |_|_|  \n      |    \n     -|- _ \n     _|_|_|\n";
		return icon;
	}

}
