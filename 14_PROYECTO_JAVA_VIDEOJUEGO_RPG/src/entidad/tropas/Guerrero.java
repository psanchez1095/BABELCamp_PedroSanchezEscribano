package entidad.tropas;

import entidad.armas.Espada;

public class Guerrero extends Tropa {
	
	public static String icon = "    __^__  \n    |___|  \n     ___   \n    __|__  \n";
	private String armaEspecial="Espada de Damocles";
	private int saludExtraArmaEspecial;
	
	@Override
	public void atacar(Object ini,Object o) {
		
		//Si el arma corresponde con la favorita para el tipo Guerrero se aumenta el daño un 10%
		if(this.getArma() instanceof Espada) {
			
			//Si lleva el arma especial se cura 30 puntos de vida al atacar
			if(this.getArma().getNombre().equals(armaEspecial)) {
				this.setSalud(this.getSalud()+this.getSaludExtraArmaEspecial());
			}
			
			int dañoAct =this.getArma().getDaño();
			this.getArma().setDaño(this.getArma().getDaño()+this.getArma().getDaño()/10);
			this.getArma().usar(ini,o);
			this.getArma().setDaño(dañoAct);
			
		}
		else this.getArma().usar(ini,o);
	}

	public Guerrero() {
		super();
		this.setNombre("Guerero");
		this.setArma(new Espada());
		this.getArma().setNombre("Espada");
		this.setSaludExtraArmaEspecial(30);
	}

	public int getSaludExtraArmaEspecial() {
		return saludExtraArmaEspecial;
	}

	public void setSaludExtraArmaEspecial(int saludExtraArmaEspecial) {
		this.saludExtraArmaEspecial = saludExtraArmaEspecial;
	}

	@Override
	public String paintIcon() {
		String icon = "    __^__  \n    |___|  \n     ___   \n    __|__  \n";
		return icon;
	}
	
}
