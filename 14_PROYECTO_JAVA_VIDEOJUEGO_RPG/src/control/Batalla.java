package control;

import java.util.ArrayList;
import java.util.Random;

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
					player.atacar(enemies.get(n));
					if (enemies.get(n).getSalud() <= 0)
						enemies.remove(n);
					n = 51;
					break;
				// HUIR
				case 2:
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
				enemies.get(n).atacar(player);

				// CAMBIO DE TURNO
				n = 100 / 2 - 1;
			}

			infoBatalla();

		} while (player.getSalud() > 0 && !enemies.isEmpty());

		if (player.getSalud() <= 0)
			return false;
		else {
			System.out.println("   ----" + " El enemigo ha muerto, tu camino sigue" + " ----");
			return true;
		}

	}

	/**
	 * Metodo que se encarga de mostrar por pantalla las opciones que tiene el
	 * jugador durante la batalla.
	 * 
	 */
	void menuBatalla() {

		System.out.println("           1- Atacar");
		System.out.println("           2- Huir");
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
