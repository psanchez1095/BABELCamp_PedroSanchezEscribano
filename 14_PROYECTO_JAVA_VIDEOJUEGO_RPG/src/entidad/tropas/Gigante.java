package entidad.tropas;

import entidad.armas.Espada;
import entidad.armas.Manos;

public class Gigante extends Tropa {

	public static String icon = "   ________\n  | -    - |\n  |___  ___|\n  ----||----\n    __||__\n    |    |\n";
	String armaEspecial = "Puños de Hierro";
	private int saludExtraArmaEspecial;

	public Gigante() {
		super();
		this.setNombre("Gigante");
		this.setArma(new Manos());
		this.getArma().setNombre("Puño");
		this.setSaludExtraArmaEspecial(30);
	}

	private int getSaludExtraArmaEspecial() {
		return this.saludExtraArmaEspecial;
	}

	private void setSaludExtraArmaEspecial(int i) {
		this.saludExtraArmaEspecial = i;

	}

	@Override
	public void atacar(Object ini,Object o) {
		// Si el arma corresponde con la favorita para el tipo Guerrero se aumenta el
		// daño un 10%
		if (this.getArma() instanceof Manos) {

			// Si lleva el arma especial se cura 30 puntos de vida al atacar
			if (this.getArma().getNombre().equals(armaEspecial)) {
				this.setSalud(this.getSalud() + this.getSaludExtraArmaEspecial());
			}

			int dañoAct = this.getArma().getDaño();
			this.getArma().setDaño(this.getArma().getDaño() + this.getArma().getDaño() / 10);
			this.getArma().usar(ini,o);
			this.getArma().setDaño(dañoAct);

		} else
			this.getArma().usar(ini,o);

	}

	@Override
	public String paintIcon() {
		/*
		 * System.out.println("   ________  ");
		 * System.out.println("  | -    - |  ");
		 * System.out.println("  |___  ___|  "); 
		 * System.out.println("  ----||----    ");
		 * System.out.println("    __||__    "); 
		 * System.out.println("    |    |   ");
		 */
		String icon = "   ________\n  | -    - |\n  |___  ___|\n  ----||----\n    __||__\n    |    |\n";
		return icon;
	}

}
