package entidad.tropas;

import control.Fortaleza;
import entidad.armas.Hechizo;

public class Mago extends Tropa{
	
	String armaEspecial = "Cetro de Fuego";
	private int saludExtraArmaEspecial;
	public static String icon = "    __*__  \n    |___|  \n     -|-   \n     -|-  \n    __|__\n";
	
	public Mago() {
		super();
		this.setNombre("Mago");
		this.setArma(new Hechizo());
		this.getArma().setNombre("Hechizo");
		this.setSaludExtraArmaEspecial(30);
	}
	public Mago(Fortaleza fortaleza) {
		super();
		this.setNombre("Mago");
		this.setArma(new Hechizo());
		this.getArma().setNombre("Hechizo");
		this.setSaludExtraArmaEspecial(30);
		this.setFortaleza(fortaleza);
	}
	
	
	@Override
	public void atacar(Object ini,Object o) {

		// Si el arma corresponde con la favorita para el tipo Mago se aumenta el da�o
		// un 10%
		if (this.getArma() instanceof Hechizo) {

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

	
	public int getSaludExtraArmaEspecial() {
		return saludExtraArmaEspecial;
	}

	public void setSaludExtraArmaEspecial(int saludExtraArmaEspecial) {
		this.saludExtraArmaEspecial = saludExtraArmaEspecial;
	}

	public String paintIcon() {
		String icon = "    __*__  \n    |___|  \n     -|-   \n     -|-  \n    __|__\n";
		return icon;
	}
}
