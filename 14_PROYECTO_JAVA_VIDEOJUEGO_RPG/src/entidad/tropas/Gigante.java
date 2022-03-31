package entidad.tropas;

import entidad.armas.Espada;
import entidad.armas.Manos;

public class Gigante extends Tropa {

	public static String icon = "   ________\n  | -    - |\n  |___  ___|\n  ----||----\n    __||__\n    |    |\n";
	String armaEspecial = "Pu�os de Hierro";
	private int saludExtraArmaEspecial;

	public Gigante() {
		super();
		this.setNombre("Gigante");
		this.setArma(new Manos());
		this.getArma().setNombre("Pu�o");
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
		// da�o un 10%
		if (this.getArma() instanceof Manos) {

			// Si lleva el arma especial se cura 30 puntos de vida al atacar
			if (this.getArma().getNombre().equals(armaEspecial)) {
				this.setSalud(this.getSalud() + this.getSaludExtraArmaEspecial());
			}

			int da�oAct = this.getArma().getDa�o();
			this.getArma().setDa�o(this.getArma().getDa�o() + this.getArma().getDa�o() / 10);
			this.getArma().usar(ini,o);
			this.getArma().setDa�o(da�oAct);

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
