package vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;
import modelo.persistencia.DaoCocheMySQL;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		GestorCoche gCoche = new GestorCoche();
		
		int id ;
		String matricula;
		String marca ;
		String modelo ;
		double numeroKm ;
		Coche car;
		
		System.out.println("Bienvenidos a nuestra CRUD de personas");
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			
			case 0:
				exit = true;
				break;
				
			case 1:
				
				System.out.println("Introduzca los datos del nuevo vehiculo (matricula/marca/modelo/numeroKilometros)");
			
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				numeroKm = sc.nextDouble();
			
			
				
				car = new Coche(1, matricula, marca, modelo, numeroKm);
				car.setId(1);
				car.setMatricula(matricula);
				car.setMarca(marca);
				car.setModelo(modelo);
				car.setKilometros(numeroKm);
				
				int alta = gCoche.alta(car);
				
				if(alta == 0) {
					System.out.println("Vehiculo dado de alta con éxito");
				}else if(alta == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(alta == 2){
					System.out.println("La matricula del vehiculo debe tener exactamente siete carateres");
				}else if(alta == 3){
					System.out.println("Los kilometros deben ser un número positivo");
				}else if(alta == 4){
					System.out.println("La matricula del vehiculo debe tener exactamente siete carateres\nLos kilometros deben ser un número positivo");
				}
				break;
				
			case 2:
				
				System.out.println("Introduzca el id del vehiculo que quiere dar de baja");
			
				id = sc.nextInt();
			
			
				int baja = gCoche.baja(id);
				
				if(baja == 0) System.out.println("Vehiculo dado de baja con éxito");
				else if (baja == 1 ) System.out.println("No existe ningun vehículo con id " + id);
				else System.out.println("Error de conexión con la BBDD");
				break;
				
			case 3:
				
				System.out.println("Introduzca los datos a modificar del vehiculo (id/matricula/marca/modelo/numeroKilometros)");
				
				id = sc.nextInt();
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				numeroKm = sc.nextDouble();
			
			
				
				car = new Coche(id, matricula, marca, modelo, numeroKm);
				car.setId(1);
				car.setMatricula(matricula);
				car.setMarca(marca);
				car.setModelo(modelo);
				car.setKilometros(numeroKm);
				
				alta = gCoche.modificar(car);
				
				if(alta == 0) {
					System.out.println("Vehiculo modificado éxito");
				}else if(alta == 1) {
					System.out.println("El vehiculo con id "+ car.getId() + " no existe");
				}else if(alta == 2){
					System.out.println("La matricula del vehiculo debe tener exactamente siete carateres");
				}else if(alta == 3){
					System.out.println("Los kilometros deben ser un número positivo");
				}else if(alta == 4){
					System.out.println("La matricula del vehiculo debe tener exactamente siete carateres\nLos kilometros deben ser un número positivo");
				}
				else if(alta == 5) {
					System.out.println("Error de conexión con la BBDD");
				}
				
				break;


			}
			
		}while(!exit);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("\n Elija una opción:");
		System.out.println(" 0- Salir del programa");
		System.out.println(" 1- Alta de Vehiculo");
		System.out.println(" 2- Baja de Vehiculo");
		System.out.println(" 3- Modificar Vehiculo");
	}

		
	}


