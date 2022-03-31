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

	public static Scanner in = new Scanner(System.in);
	Tropa player;
	Tropa aux;
	String auxIn;
	int dañoPlayerGuerrero = 150, dañoPlayerCurandero = -75, dañoPlayerMago = 200,dañoPlayerGigante = 100;
	int saludPlayerGuerrero = 1000, saludPlayerCurandero = 500, saludPlayerMago = 500,saludPlayerGigante = 1600;

	public void run() {

		boolean exit = false;
		title();

		do {
			menu();

			int opcion = in.nextInt();

			switch (opcion) {

			case 0:
				System.out.println("\n  Apagando el juego...");
				break;

			case 1:
				System.out.println("\n Elige el tipo de tropa que quieres usar:");
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

				System.out.println(player.paintIcon());
				System.out.println(
						"\n    El arma por defecto del " + player.getNombre() + " es " + player.getArma().getNombre());
				System.out.println("\n\n    Parece que se acerca algo");

				System.out.println(" Pulse una tecla...");
				auxIn = in.next();
				//PRIMERA BATALLA
				/* Genero primera tropa enemiga */
				Tropa enemy = generateRandomEnemy();

				ArrayList<Tropa> enemies = new ArrayList<Tropa>();
				enemies.add(enemy);

				for (Tropa en : enemies) {
					System.out.println(en.paintIcon());
					System.out.println("    Enemy  ");
				}

				/* Genero la primera batalla */
				Batalla battle = new Batalla();
				battle.setPlayer(player);
				battle.setEnemy(enemies);

				System.out.println(" Pulse una tecla...");
				auxIn = in.next();

				boolean playerWins = battle.fight();
				if(!playerWins) {
					playerDead();
					break;
				}
				//SEGUNDA BATALLA
				/* Genero primera tropa enemiga */
				enemy = generateRandomEnemy();

				enemies = new ArrayList<Tropa>();
				enemies.add(enemy);
				enemy = generateRandomEnemy();
				enemies.add(enemy);

				for (Tropa en : enemies) {
					System.out.println(en.paintIcon());
					System.out.println("    Enemy  ");
				}

				battle = new Batalla();
				battle.setPlayer(player);
				battle.setEnemy(enemies);

				playerWins = battle.fight();
				if(!playerWins) {
					playerDead();
					break;
				}
				break;

			case 2:
				infoTropas();
				break;
			}
		} while (!exit);

	}

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
					enemy.getArma().setDaño(180);
				} else if (tropa.equals(TropasEnum.Curandero)) {
					enemy = new Curandero();
					enemy.setSalud(150);
					enemy.getArma().setDaño(-40);
				}else if (tropa.equals(TropasEnum.Gigante)) {
				enemy = new Gigante();
				enemy.setSalud(1300);
				enemy.getArma().setDaño(65);
			}

			}
			contador++;
		}

		return enemy;

	}

	private void infoTropas() {
		System.out.println(Guerrero.icon);
		System.out.println("    " + TropasEnum.Guerrero);
		System.out.println(" PS " + this.saludPlayerGuerrero + " POT " + this.dañoPlayerGuerrero);
		System.out.println("\n");
		System.out.println(Mago.icon);
		System.out.println("     " + TropasEnum.Mago);
		System.out.println(" PS " + this.saludPlayerMago + " POT " + this.dañoPlayerMago);
		System.out.println("\n");
		System.out.println(Curandero.icon);
		System.out.println("   " + TropasEnum.Curandero);
		System.out.println(" PS " + this.saludPlayerCurandero + " POT " + this.dañoPlayerCurandero);
		System.out.println("\n");
		System.out.println(Gigante.icon);
		System.out.println("   " + TropasEnum.Gigante);
		System.out.println(" PS " + this.saludPlayerGigante + " POT " + this.dañoPlayerGigante);
		System.out.println("\n");
	}

	void title() {

		System.out.println("\n     ______________________________");
		System.out.println("    |______________________________|");
		System.out.println("    |                              |");
		System.out.println("    |           RPG GAME           |");
		System.out.println("    |                              |");
		System.out.println("    | Pedro S            BabelCamp |");
		System.out.println("    --------------------------------");

	}

	void menu() {
		System.out.println("     ______________________________");
		System.out.println("\n          Elija una opción:");
		System.out.println("           0- Salir del programa");
		System.out.println("           1- Nueva Partida");
		System.out.println("           2- Info Tropas");
		System.out.println("     ______________________________");
	}
	
	void playerDead() {
		System.out.println("    ------JUGADOR "+player.getNombre()+" HA MUERTO------");
		System.out.println("    ---FIN DE LA PARTIDA---");
	}

	void menuTropaPlayer() {
		int i = 1;
		for (TropasEnum tropa : TropasEnum.values()) {
			System.out.println("   " + i + "- " + tropa);
			i++;
		}
	}
}
