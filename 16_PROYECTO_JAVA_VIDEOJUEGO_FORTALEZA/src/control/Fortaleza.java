package control;

import java.util.ArrayList;

import entidad.tropas.Gigante;
import entidad.tropas.Tropa;

public class Fortaleza {
	
	private String nombre;
	private ArrayList<Tropa> jefe;
	private Batalla batalla;
	private int totalJefesDead;
	
	public Fortaleza() {
		super();
		jefe= new ArrayList<Tropa>();
		Tropa aux = new Gigante();
		aux.setSalud(2500);
		aux.setNombre("Gigante Noble Custodiador");
		aux.getArma().setNombre(((Gigante) aux).getArmaEspecial());
		aux.getArma().setDaño(150);
		jefe.add(aux);
	}
	
	public ArrayList<Tropa> getJefe() {
		return jefe;
	}
	public void setJefe(ArrayList<Tropa> jefe) {
		jefe = jefe;
	}
	public Batalla getBatalla() {
		return batalla;
	}
	public void setBatalla(Batalla batalla) {
		this.batalla = batalla;
	}
	
	public synchronized void acceder(Tropa tropa){
		batalla = new Batalla();
		batalla.setPlayer(tropa);
		batalla.setEnemy(jefe);
		totalJefesDead=batalla.fight();
		
		if(jefe.isEmpty()) fortalezaTomada(tropa);
		else tomaFortalezaFallida(tropa);
			
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	void tomaFortalezaFallida(Tropa player) {
		System.out.println("    ------"+ player.getNombre().toUpperCase()+" "+player.getNombrePlayer().toUpperCase() + " HA MUERTO------");
		System.out.println("\n               ESTADÍSTICAS");
		System.out.println(player.toString());
		System.out.println("\n    ------ DEBEN ACUDIR REFUERZOS ------\n");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla que el jugador ha tomado la fortaleza y finaliza la partida
	 * 
	 */
	private void fortalezaTomada(Tropa player) {
		System.out.println(
				"    ------"+ player.getNombre().toUpperCase()+" "+player.getNombrePlayer().toUpperCase() + " TOMO LA FORTALEZA------");
		System.out.println("\n               ESTADÍSTICAS");
		System.out.println(player.toString());
		System.out.println("         -enemigos eliminados: "+totalJefesDead);
		System.out.println("\n                   ---FIN DE LA PARTIDA---");
	}
}
