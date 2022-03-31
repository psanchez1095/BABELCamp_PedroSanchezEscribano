package entidad.armas;

import entidad.tropas.Tropa;

public class Rezo extends Arma {
	
	public Rezo() {
		super();
	}
	@Override
	public void usar(Object o) {
		 
		if(o.equals(this)) {((Tropa) o).setSalud(((Tropa) o).getSalud()-(this.getDaño()));}
		else ((Tropa) o).setSalud(((Tropa) o).getSalud()+(this.getDaño()/3));
	
		}
	

}
