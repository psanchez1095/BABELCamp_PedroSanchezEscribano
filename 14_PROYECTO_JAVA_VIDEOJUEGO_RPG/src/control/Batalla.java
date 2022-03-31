package control;

import java.util.ArrayList;
import java.util.Random;

import entidad.armas.Arma;
import entidad.tropas.Curandero;
import entidad.tropas.Gigante;
import entidad.tropas.Guerrero;
import entidad.tropas.Mago;
import entidad.tropas.Tropa;

public class Batalla {

	private Tropa player;
	private ArrayList<Tropa> enemies;
	private String auxIn;

	public Batalla() {
	}

	public Tropa getPlayer() {
		return player;
	}

	public void setPlayer(Tropa player) {
		this.player = player;
	}

	public ArrayList<Tropa> getEnemy() {
		return enemies;
	}

	public void setEnemy(ArrayList<Tropa> enemy) {
		this.enemies = enemy;
	}

	/**
	 * Metodo que se encarga de llevar a cabo una batalla entre dos tropas.
	 * 
	 * @return true en caso de que el jugador haya ganado la batalla False en caso
	 *         contrario.
	 */
	public boolean fight() {

		System.out.println("   ---------------------------------------");
		System.out.println("                 Batalla      ");
		System.out.println("\n");

		infoBatalla();

		Random rd = new Random();
		// Aleatorio entre 0 y 100 para decidir quien empieza atacando
		int n = rd.nextInt(101);

		System.out.println(" Comienza la Batalla. Pulse una tecla...");
		auxIn = Game.in.next();

		do {

			// TURNO DEL USUARIO
			if (n <= 50) {

				System.out.println("   ---------Jugador " + player.getNombre() + " Ataca" + "----------");

				menuBatalla();

				int opcion = Game.in.nextInt();

				// Aleatorio entre 0 y el numero de enemigos
				n = rd.nextInt(enemies.size());
				switch (opcion) {

				// ATACAR
				case 1:
					player.atacar(player,enemies.get(n));
					if (enemies.get(n).getSalud() <= 0)
						enemies.remove(n);
					n = 51;
					break;
				// ATACAR
				case 2:
					player.atacar(player,player);
					if(!(player instanceof Curandero))System.out.println("   ---Jugador " + player.getNombre() + " se defendió pero no logró nada" + "---");
					n = 51;
					break;
				// HUIR
				case 3:
					rd = new Random();
					// Aleatorio entre 0 y 100
					n = rd.nextInt(101);

					if (n <= 1 / 4) {
						System.out.println("   <<<<  Jugador " + player.getNombre() + " pudo escapar  >>>>\n");
						return true;
					} else
						System.out.println("   <<<<  Jugador " + player.getNombre() + " no pudo escapar  >>>>\n");

					// CAMBIO DE TURNO
					n = 100 / 2 + 1;
					break;

				}

			}
			// TURNO DEL ENEMIGO
			else {
				// Aleatorio para ver que enemigo ataca
				n = rd.nextInt(enemies.size());
				System.out.println("   ---------" + enemies.get(n).getNombre() + " Enemigo Ataca" + "-----------");
				enemies.get(n).atacar(enemies.get(n),player);

				// CAMBIO DE TURNO
				n = 100 / 2 - 1;
			}

			infoBatalla();

		} while (player.getSalud() > 0 && !enemies.isEmpty());

		if (player.getSalud() <= 0)
			return false;
		else {
			System.out.println("   ----" + " El enemigo ha muerto, tu camino sigue" + " ----");
			potenciador();
			return true;
		}

	}

	/**
	 * Metodo que se encarga de generar al azar un potenciador para el jugador
	 * cuando se ha ganado una batalla. El potenciador puede ser vida, daño para el
	 * arma o un arma especial.
	 */
	void potenciador() {

		Random rd = new Random();

		int n = rd.nextInt(101);
		// ARMA ESPECIAL
		if (n <= 15) {
			generarArmaEspecial();
			System.out.println(
					"   ---" + "Jugador " + player.getNombre() + " encontró " + player.getArma().getNombre() + "---");
			System.out.println("\n");
		}
		// PUNTOS DE SALUD
		else if (n <= 75) {
			System.out.println("   ---" + "Jugador " + player.getNombre() + " encontró vendas y medicinas---");
			System.out.println("\n");
			player.setSalud(player.getSalud() + 100);
		}
		// AUMENTO DAÑO ARMA
		else {
			System.out.println("      ---" + "Jugador " + player.getNombre() + " encontró un amuleto---");
			System.out.println("\n");
			player.getArma().setDaño(player.getArma().getDaño() + 30);
		}

	}

	/**
	 * Metodo que se encarga de generar arma especial para el jugador dependiendo
	 * del tipo de tropa que sea.
	 */
	private void generarArmaEspecial() {

		if (player instanceof Guerrero) {
			player.getArma().setNombre("Espada de Damocles");
			player.getArma().setDaño(player.getArma().getDaño() + 75);
		} else if (player instanceof Mago) {
			player.getArma().setNombre("Cetro de Fuego");
			player.getArma().setDaño(player.getArma().getDaño() + 75);
		} else if (player instanceof Curandero) {
			player.getArma().setNombre("Libro Sagrado");
			player.getArma().setDaño(player.getArma().getDaño() + 75);
		} else if (player instanceof Gigante) {
			player.getArma().setNombre("Puño de Hierro");
			player.getArma().setDaño(player.getArma().getDaño() + 75);
		}

	}

	/**
	 * Metodo que se encarga de mostrar por pantalla las opciones que tiene el
	 * jugador durante la batalla.
	 * 
	 */
	void menuBatalla() {
		System.out.println("           1- Atacar");
		System.out.println("           2- Defenderse/Curarse");
		System.out.println("           3- Huir");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla la informacion del jugador y
	 * del enemigo en batalla.
	 * 
	 */
	void infoBatalla() {
		System.out.print(this.player.paintIcon());

		int pSalud = player.getSalud();
		if (pSalud < 0)
			pSalud = 0;

		System.out.println(" Player PS " + pSalud + "   ");
		System.out.println("\n");
		System.out.println("                 --Enemies--");
		System.out.println("\n");

		for (Tropa p : enemies) {
			System.out.print(p.paintIcon());

			int eSalud = p.getSalud();
			if (eSalud < 0)
				eSalud = 0;

			System.out.println(" Enemy PS " + eSalud + "   ");
			System.out.println("\n");
		}

	}

}
