package entidad.armas;

import entidad.tropas.Tropa;

public class Rezo extends Arma {
	
	public Rezo() {
		super();
	}
	/**
	 * Metodo que se encarga de usar el arma
	 * @param ini es la tropa que inicia la accion con el arma 
	 * @param o es la tropa que recibe la accion con el arma 
	 */
	@Override
	public void usar(Object ini,Object o) {
		//Si se usa el rezo sobre uno mismo se cura
		if(ini.equals(o)) {
		
			((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDaño()));
			
		}
		//Si no ataca con la mitad del daño
		else ((Tropa) o).setSalud(((Tropa) o).getSalud()+(this.getDaño()/2));
	
		}
	

}
