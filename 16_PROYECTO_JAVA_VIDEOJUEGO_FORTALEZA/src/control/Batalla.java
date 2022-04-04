package control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entidad.armas.Arma;
import entidad.tropas.Curandero;
import entidad.tropas.Gigante;
import entidad.tropas.Guerrero;
import entidad.tropas.Mago;
import entidad.tropas.Tropa;

public class Batalla {

	private Tropa player;
	private ArrayList<Tropa> enemies;
	public static Scanner in = new Scanner(System.in);
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
	 * @return int el n�mero de enemigos derrotados
	 */
	public int fight() {
		
		int enemiesDead=0;
		
		System.out.println("   ---------------------------------------");
		System.out.println("                 Batalla      ");
		System.out.println("\n");

		infoBatalla();

		Random rd = new Random();
		// Aleatorio entre 0 y 100 para decidir quien empieza atacando
		int n = rd.nextInt(101);

		System.out.println("\n    Pulse una tecla...");
		in.next();

		do {

			// TURNO DEL USUARIO
			if (n <= 50) {

				System.out.println("   ---------" + player.getNombre()+" "+player.getNombrePlayer() + " Ataca" + "----------");

				menuBatalla();

				int opcion = in.nextInt();

				// Aleatorio entre 0 y el numero de enemigos
				n = rd.nextInt(enemies.size());
				switch (opcion) {

				// ATACAR
				case 1:
					player.atacar(player,enemies.get(n));
					if (enemies.get(n).getSalud() <= 0) {
						enemies.remove(n);
						enemiesDead++;
						}
					n = 51;
					break;
				// DEFENDERSE/CURARSE ( ACCIONES CONTRA UNO MISMO )
				case 2:
					player.atacar(player,player);
					if(!(player instanceof Curandero))System.out.println("   ---"+ player.getNombre()+" "+player.getNombrePlayer() + " se defendi� pero no logr� nada" + "---");
					n = 51;
					break;
				// HUIR
				case 3:
					rd = new Random();
					// Aleatorio entre 0 y 100
					n = rd.nextInt(101);

					if (n <= 1 / 4) {
						System.out.println("   <<<<  " + player.getNombre()+" "+player.getNombrePlayer() + " pudo escapar  >>>>\n");
						return -1;
					} else
						System.out.println("   <<<<  " + player.getNombre()+" "+player.getNombrePlayer() + " no pudo escapar  >>>>\n");

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
			return enemiesDead;
		else {
			System.out.println("   ----" + " El enemigo ha muerto, tu camino sigue" + " ----");
			potenciador();
			return enemiesDead;
		}

	}

	/**
	 * Metodo que se encarga de generar al azar un potenciador para el jugador
	 * cuando se ha ganado una batalla. El potenciador puede ser vida, da�o para el
	 * arma o un arma especial.
	 */
	void potenciador() {

		Random rd = new Random();

		int n = rd.nextInt(101);
		// ARMA ESPECIAL
		if (n <= 15) {
			generarArmaEspecial();
			System.out.println(
					"   ---" + player.getNombre()+" "+player.getNombrePlayer() + " encontr� " + player.getArma().getNombre() + "---");
			System.out.println("\n");
		}
		// PUNTOS DE SALUD
		else if (n <= 75) {
			System.out.println("   ---" + player.getNombre()+" "+player.getNombrePlayer() + " encontr� vendas y medicinas---");
			System.out.println("\n");
			player.setSalud(player.getSalud() + 100);
		}
		// AUMENTO DA�O ARMA
		else {
			System.out.println("      ---" + player.getNombre()+" "+player.getNombrePlayer() + " encontr� un amuleto---");
			System.out.println("\n");
			player.getArma().setDa�o(player.getArma().getDa�o() + 30);
		}

	}

	/**
	 * Metodo que se encarga de generar arma especial para el jugador dependiendo
	 * del tipo de tropa que sea.
	 */
	private void generarArmaEspecial() {

		if (player instanceof Guerrero) {
			player.getArma().setNombre("Espada de Damocles");
			player.getArma().setDa�o(player.getArma().getDa�o() + 75);
		} else if (player instanceof Mago) {
			player.getArma().setNombre("Cetro de Fuego");
			player.getArma().setDa�o(player.getArma().getDa�o() + 75);
		} else if (player instanceof Curandero) {
			player.getArma().setNombre("Libro Sagrado");
			player.getArma().setDa�o(player.getArma().getDa�o() - 100);
		} else if (player instanceof Gigante) {
			player.getArma().setNombre("Pu�o de Hierro");
			player.getArma().setDa�o(player.getArma().getDa�o() + 125);
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
