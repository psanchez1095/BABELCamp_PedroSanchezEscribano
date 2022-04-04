package control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import entidad.tropas.Curandero;
import entidad.tropas.Gigante;
import entidad.tropas.Guerrero;
import entidad.tropas.Mago;
import entidad.tropas.Tropa;
import utils.TropasEnum;

public class Game {

	private final int RONDAS_JUEGO = 2;
	public static Scanner in = new Scanner(System.in);
	private Tropa player;
	private Fortaleza fortaleza;
	private ArrayList<Tropa> enemies;
	private int totalEnemiesDead;
	private int dañoPlayerGuerrero = 150, dañoPlayerCurandero = -55, dañoPlayerMago = 200, dañoPlayerGigante = 100;
	private int saludPlayerGuerrero = 1000, saludPlayerCurandero = 500, saludPlayerMago = 500,
			saludPlayerGigante = 1600;

	/**
	 * Método en el que transcurre el desarrollo de una partida. Se crea el objeto
	 * jugado y los enemigos.
	 * 
	 */
	public void run() {

		boolean exit = false;

		title();

		do {
			menu();

			int opcion = in.nextInt();

			switch (opcion) {
			
			// SALIR DEL JUEGO
			case 0:
				System.out.println("\n  Apagando el juego...");
				exit = true;
				break;
				
			// NUEVA PARTIDA MODO NORMAL
			case 1:

				menuTropaPlayer();

				opcion = in.nextInt();

				switch (opcion) {

				case 1:
					player = new Guerrero();
					player.setSalud(saludPlayerGuerrero);
					player.getArma().setDaño(dañoPlayerGuerrero);
					break;
				case 2:
					player = new Curandero();
					player.setSalud(saludPlayerCurandero);
					player.getArma().setDaño(dañoPlayerCurandero);
					break;
				case 3:
					player = new Mago();
					player.setSalud(saludPlayerMago);
					player.getArma().setDaño(dañoPlayerMago);
					break;
				case 4:
					player = new Gigante();
					player.setSalud(saludPlayerGigante);
					player.getArma().setDaño(dañoPlayerGigante);
					break;

				}
				System.out.println("   Elige un nombre para el " + player.getNombre());

				player.setNombrePlayer(in.next());

				paintNewPlayer();

				System.out.println("\n    Pulse una tecla...");
				in.next();

				generateRounds(RONDAS_JUEGO);

				break;
				
			// NUEVA PARTIDA MODO FORTALEZA
			case 2:
				
				System.out.println("\n   Elige cuantas personas asaltan la fortaleza hoy:");
				int asaltantes = in.nextInt();
				fortaleza = new Fortaleza();
				Thread auxHilo ; 
				
				for(int i=0;i<asaltantes;i++) {
					
					Tropa auxTropa=generateRandomEnemy();
					auxTropa.setFortaleza(fortaleza);
					auxTropa.setNombrePlayer("Thor");
					auxHilo = new Thread(auxTropa);
					auxHilo.start();
					try {
						//Con join se ejecuta el hilo tx y se pausa el hilo principal hasta que el termina
						auxHilo.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
					
				break;
				
			// INFORMACION DE TROPAS
			case 3:
				infoTropas();
				break;

			}

		} while (!exit);

	}

	/**
	 * Método que genera unas cuantas rondas cada una con su correspondiente
	 * batalla.
	 * 
	 * @param rounds tipo int que define el número de rondas.
	 */
	void generateRounds(int rounds) {

		Tropa enemy;
		int playerWins;
		Batalla battle;
		enemies = new ArrayList<Tropa>();

		for (int i = 0; i < rounds; i++) {

			// Genera dos enemigos aleatorios por ronda
			enemy = generateRandomEnemy();
			enemies.add(enemy);
			enemy = generateRandomEnemy();
			enemies.add(enemy);

			// Muestra el icono de cada enemigo
			for (Tropa en : enemies) {
				System.out.println(en.paintIcon());
				System.out.println("    Enemy  ");
			}

			// Genera una nueva batalla con el jugador y los enemigos
			battle = new Batalla();
			battle.setPlayer(player);
			battle.setEnemy(enemies);

			// Analiza el resultado de la batalla
			int enemiesPreBattle = enemies.size();

			playerWins = battle.fight();
			totalEnemiesDead += playerWins;

			// En caso de no haber huido y si no ha matado a todos los enemigos
			// partida
			if (playerWins != -1 && playerWins != enemiesPreBattle) {
				playerDead();
				break;
			}
			// En caso de ser la última ronda y el jugador siga vivo el jugador ganó la
			// partida
			if (i == RONDAS_JUEGO - 1 && playerWins == enemiesPreBattle) {
				playerWin();
				break;
			}

		}
	}

	/**
	 * Método que generá una tropa aleatoriamente en función de un numero aleatorio.
	 * 
	 * @return Devuelve una referencia de tipo Tropa en caso de éxito Null en caso
	 *         contrario.
	 */
	Tropa generateRandomEnemy() {

		Tropa enemy = null;

		Random rd = new Random();
		int n = rd.nextInt(TropasEnum.values().length);
		int contador = 0;

		for (TropasEnum tropa : TropasEnum.values()) {

			if (n == contador) {

				if (tropa.equals(TropasEnum.Guerrero)) {
					enemy = new Guerrero();
					enemy.setSalud(450);
					enemy.getArma().setDaño(100);
				} else if (tropa.equals(TropasEnum.Mago)) {
					enemy = new Mago();
					enemy.setSalud(400);
					enemy.getArma().setDaño(140);
				} else if (tropa.equals(TropasEnum.Curandero)) {
					enemy = new Curandero();
					enemy.setSalud(150);
					enemy.getArma().setDaño(-40);
				} else if (tropa.equals(TropasEnum.Gigante)) {
					enemy = new Gigante();
					enemy.setSalud(1300);
					enemy.getArma().setDaño(45);
				}

			}
			contador++;
		}

		return enemy;

	}

	/**
	 * Metodo que se encarga de mostrar por pantalla las diferentes tropas y su
	 * informacion de vida y daño
	 * 
	 */
	private void infoTropas() {
		System.out.println(Guerrero.icon);
		System.out.println("   " + TropasEnum.Guerrero);
		System.out.println(" PS " + this.saludPlayerGuerrero + " POT " + this.dañoPlayerGuerrero);
		System.out.println(Mago.icon);
		System.out.println("     " + TropasEnum.Mago);
		System.out.println(" PS " + this.saludPlayerMago + " POT " + this.dañoPlayerMago);
		System.out.println(Curandero.icon);
		System.out.println("   " + TropasEnum.Curandero);
		System.out.println(" PS " + this.saludPlayerCurandero + " POT " + this.dañoPlayerCurandero);
		System.out.println(Gigante.icon);
		System.out.println("    " + TropasEnum.Gigante);
		System.out.println(" PS " + this.saludPlayerGigante + " POT " + this.dañoPlayerGigante);
		System.out.println("\n");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla el titulo del juego
	 * 
	 */
	void title() {
		System.out.println("\n     ______________________________");
		System.out.println("    |______________________________|");
		System.out.println("    |                              |");
		System.out.println("    |           RPG GAME           |");
		System.out.println("    |                              |");
		System.out.println("    | Pedro S            BabelCamp |");
		System.out.println("    --------------------------------");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla el menu principal del juego
	 * 
	 */
	void menu() {
		System.out.println("     ______________________________");
		System.out.println("\n          Elija una opción:");
		System.out.println("           0- Salir del programa");
		System.out.println("           1- Nueva Partida");
		System.out.println("           2- Nueva Partida Modo Fortaleza");
		System.out.println("           3- Info Tropas");
		System.out.println("     ______________________________");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla que el jugador ha muerto y
	 * finaliza la partida
	 * 
	 */
	void playerDead() {
		System.out.println("    ------" + player.getNombre().toUpperCase() + " "
				+ player.getNombrePlayer().toUpperCase() + " HA MUERTO------");
		System.out.println("\n               ESTADÍSTICAS");
		System.out.println(player.toString());
		System.out.println("         -enemigos eliminados: " + totalEnemiesDead);
		System.out.println("\n           ---FIN DE LA PARTIDA---");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla que el jugador ha ganado la
	 * partida y finaliza la partida
	 * 
	 */
	private void playerWin() {
		System.out.println("    ------" + player.getNombre().toUpperCase() + " "
				+ player.getNombrePlayer().toUpperCase() + " DERROTÓ A TODOS LOS ENEMIGOS------");
		System.out.println("\n               ESTADÍSTICAS");
		System.out.println(player.toString());
		System.out.println("         -enemigos eliminados: " + totalEnemiesDead);
		System.out.println("\n                   ---FIN DE LA PARTIDA---");
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla el menu de elección de tropa
	 * 
	 */
	void menuTropaPlayer() {
		System.out.println("\n   Elige el tipo de tropa que quieres usar:");
		int i = 1;
		for (TropasEnum tropa : TropasEnum.values()) {
			System.out.println("     " + i + "- " + tropa);
			i++;
		}
	}

	/**
	 * Metodo que se encarga de mostrar por pantalla por primera vez el jugador
	 * elegido
	 * 
	 */
	void paintNewPlayer() {
		System.out.println(player.paintIcon());
		System.out
				.println("\n    El arma por defecto del " + player.getNombre() + " es " + player.getArma().getNombre());
		System.out.println("\n\n    Parece que se acerca algo");

	}

}
