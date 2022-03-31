package entidad.tropas;

import entidad.armas.Hechizo;

public class Mago extends Tropa {

	public static String icon = "    __*__  \n    |___|  \n     -|-   \n     -|-  \n    __|__\n";

	@Override
	public void atacar(Object o) {
		
		//Si el arma corresponde con la favorita para el tipo Mago se aumenta el da�o un 10%
		if (this.getArma() instanceof Hechizo) {
			
			int da�oAct = this.getArma().getDa�o();
			this.getArma().setDa�o(this.getArma().getDa�o() + this.getArma().getDa�o() / 10);
			this.getArma().usar(o);
			this.getArma().setDa�o(da�oAct);
			
		} else
			this.getArma().usar(o);

	}

	public Mago() {
		super();
		this.setNombre("Mago");
		this.setArma(new Hechizo());
		this.getArma().setNombre("Hechizo");
	}

	public String paintIcon() {
		String icon = "    __*__  \n    |___|  \n     -|-   \n     -|-  \n    __|__\n";
		return icon;
	}
}
