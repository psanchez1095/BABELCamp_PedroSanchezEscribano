package entidad.tropas;

import entidad.armas.Espada;

public class Guerrero extends Tropa {
	
	public static String icon = "    __^__  \n    |___|  \n     ___   \n    __|__  \n";
	
	@Override
	public void atacar(Object o) {
		//Si el arma corresponde con la favorita para el tipo Guerrero se aumenta el da�o un 10%
		if(this.getArma() instanceof Espada) {
			
			int da�oAct =this.getArma().getDa�o();
			this.getArma().setDa�o(this.getArma().getDa�o()+this.getArma().getDa�o()/10);
			this.getArma().usar(o);
			this.getArma().setDa�o(da�oAct);
			
		}
		else this.getArma().usar(o);
	}

	public Guerrero() {
		super();
		this.setNombre("Guerero");
		this.setArma(new Espada());
		this.getArma().setNombre("Espada");
	}

	@Override
	public String paintIcon() {
		String icon = "    __^__  \n    |___|  \n     ___   \n    __|__  \n";
		return icon;
	}
	
}
