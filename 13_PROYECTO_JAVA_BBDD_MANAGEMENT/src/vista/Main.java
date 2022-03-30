package vista;

import java.util.ArrayList;
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
		ArrayList<Coche> lista;
		
		System.out.println(" Consulta de Vehiculos");
		do {
			
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			
			case 0:
				
				exit = true;
				break;
				
			case 1:
				
				System.out.println(" Introduzca los datos del nuevo vehiculo (matricula/marca/modelo/numeroKilometros)");
			
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
				
				System.out.println(" Introduzca el id del vehiculo que quiere dar de baja");
			
				id = sc.nextInt();
			
				int baja = gCoche.baja(id);
				
				if(baja == 0) System.out.println("Vehiculo dado de baja con éxito");
				else if (baja == 1 ) System.out.println("No existe ningun vehículo con id " + id);
				else System.out.println("Error de conexión con la BBDD");
				break;
				
			case 3:
				
				System.out.println(" Introduzca los datos a modificar del vehiculo (id/matricula/marca/modelo/numeroKilometros)");
				
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
				
			case 4:
				
				System.out.println(" Introduzca el id del vehiculo que quiere buscar");
				
				id = sc.nextInt();
			
				car = gCoche.buscarPorId(id);
				
				if(car != null) {
					System.out.println("Vehiculo encontrado con éxito");
					System.out.println("\n "+car.toString());
				}
				else System.out.println("Error de conexión con la BBDD");
				
				
				break;
				
			case 5:
				
				System.out.println(" Introduzca la marca del vehiculo que quiere buscar");
				
				marca = sc.next();
			
				lista = gCoche.buscarPorMarca(marca);
				
				if(lista != null) {
					
					System.out.println("\n Listado de Vehiculos de la marca " + marca );
					for(Coche x : lista) {
						System.out.println("\n "+x.toString());
					}
					System.out.println("\n Fin del listado");
					
				}
				else System.out.println("Error de conexión con la BBDD");
						
				break;
				
			case 6:
				
				System.out.println(" Introduzca el modelo del vehiculo que quiere buscar");
				
				modelo = sc.next();
			
				lista = gCoche.buscarPoModelo(modelo);
				
				if(lista != null) {
					
					System.out.println("\n Listado de Vehiculos del modelo " + modelo);
					for(Coche x : lista) {
						System.out.println("\n "+x.toString());
					}
					System.out.println("\n Fin del listado");
					
				}
				else System.out.println("Error de conexión con la BBDD");
				
				break;
				
			case 7:
				
				System.out.println(" Introduzca la matrícula del vehiculo que quiere buscar");
				
				matricula = sc.next();
			
				car = gCoche.buscarPoMatricula(matricula);
				
				if(car != null) {
					System.out.println("Vehiculo encontrado con éxito");
					System.out.println("\n "+car.toString());
				}
				else System.out.println("Error de conexión con la BBDD");
				
				break;
				
			case 8:
			
				lista = gCoche.listar();
				
				if(lista != null) {
					
					System.out.println("\n Listado de Vehiculos ");
					for(Coche x : lista) {
						System.out.println("\n "+x.toString());
					}
					System.out.println("\n Fin del listado");
				}
				
				else System.out.println("Error de conexión con la BBDD");
				
				break;
				
			}
			
		}while(!exit);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		
		System.out.println("\n Elija una opción:");
		System.out.println(" 0- Salir del programa");
		System.out.println(" 1- Alta de Vehículo");
		System.out.println(" 2- Baja de Vehículo");
		System.out.println(" 3- Modificar Vehículo");
		System.out.println(" 4- Buscar Vehículo por Id");
		System.out.println(" 5- Buscar Vehículo por Marca");
		System.out.println(" 6- Buscar Vehículo por Modelo");
		System.out.println(" 7- Buscar Vehículo por Matricula");
		System.out.println(" 7- Buscar Vehículo por Matricula");
		System.out.println(" 8- Listar Vehículos");
		
	}

		
	}


