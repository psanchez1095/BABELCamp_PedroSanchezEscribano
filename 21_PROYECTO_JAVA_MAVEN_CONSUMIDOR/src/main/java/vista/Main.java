package vista;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

import com.google.protobuf.Duration;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class Main {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		boolean exit = false;
		GestorCoche gCoche = new GestorCoche();

		int id;
		String matricula;
		String marca;
		String modelo;
		double numeroKm;
		Coche car;
		ArrayList<Coche> lista;
		
		//VALIDAMOS USUARIO CON HTTP CLIENT ( JAVA 11 )
		String nombre, contrase�a;
		boolean contrase�aBoolean = false;

		do {
			
			System.out.println("\n Introduzca el usuario");
			nombre = sc.next();
			System.out.println("\n Introduzca la contrase�a para " + nombre);
			contrase�a = sc.next();

			contrase�aBoolean = validarUsuario(nombre,contrase�a);
			
		} while (!contrase�aBoolean);
		
		
		System.out.println("\n Usuario identificado con �xito\n");
		System.out.println("\n Consulta de Vehiculos");

		do {

			menu();
			int opcion = sc.nextInt();
			switch (opcion) {

			// SALIR
			case 0:

				exit = true;
				break;

			// DAR DE ALTA COCHE
			case 1:

				System.out
						.println(" Introduzca los datos del nuevo vehiculo (matricula/marca/modelo/numeroKilometros)");

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
				int alta = -1;

				if (gCoche.buscarPoMatricula(car.getMatricula()) == null)
					alta = gCoche.alta(car);
				else {
					System.out.println("\n Matr�cula ya existente");
					break;
				}

				if (alta == 0) {
					System.out.println("\n Vehiculo dado de alta con �xito");
				} else if (alta == 1) {
					System.out.println("\n Error de conexi�n con la BBDD");
				} else if (alta == 2) {
					System.out.println("\n La matricula del vehiculo debe tener exactamente siete carateres");
				} else if (alta == 3) {
					System.out.println("\n Los kilometros deben ser un n�mero positivo");
				} else if (alta == 4) {
					System.out.println(
							"\n La matricula del vehiculo debe tener exactamente siete carateres\nLos kilometros deben ser un n�mero positivo");
				}
				break;

			// DAR DE BAJA COCHE
			case 2:

				System.out.println(" Introduzca el id del vehiculo que quiere dar de baja");

				id = sc.nextInt();

				int baja = gCoche.baja(id);

				if (baja == 0)
					System.out.println("Vehiculo dado de baja con �xito");
				else if (baja == 1)
					System.out.println("No existe ningun veh�culo con id " + id);
				else
					System.out.println("Error de conexi�n con la BBDD");
				break;

			// MODIFICAR COCHE
			case 3:

				System.out.println(
						" Introduzca los datos a modificar del vehiculo (id/matricula/marca/modelo/numeroKilometros)");

				id = sc.nextInt();
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				numeroKm = sc.nextDouble();

				car = new Coche(id, matricula, marca, modelo, numeroKm);

				int modificar = -1;
				if (gCoche.buscarPoMatricula(car.getMatricula()) == null
						|| gCoche.buscarPoMatricula(car.getMatricula()).getId() == car.getId())
					modificar = gCoche.modificar(car);
				else {
					System.out.println("\n Matr�cula ya existente en otro veh�culo");
					break;
				}

				modificar = gCoche.modificar(car);

				if (modificar == 0) {
					System.out.println("\n Vehiculo modificado con �xito");
				} else if (modificar == 1) {
					System.out.println("\n El vehiculo con id " + car.getId() + " no existe");
				} else if (modificar == 2) {
					System.out.println("\n La matricula del vehiculo debe tener exactamente siete carateres");
				} else if (modificar == 3) {
					System.out.println("\n Los kilometros deben ser un n�mero positivo");
				} else if (modificar == 4) {
					System.out.println(
							"\n La matricula del vehiculo debe tener exactamente siete carateres\nLos kilometros deben ser un n�mero positivo");
				} else if (modificar == 5) {
					System.out.println("\n Error de conexi�n con la BBDD");
				}

				break;

			// BUSCAR COCHE POR ID
			case 4:

				System.out.println(" Introduzca el id del vehiculo que quiere buscar");

				id = sc.nextInt();

				car = gCoche.buscarPorId(id);

				if (car != null) {
					System.out.println("\n Vehiculo encontrado con �xito");
					System.out.println("\n " + car.toString());
				} else
					System.out.println(" \nError de conexi�n con la BBDD");

				break;

			// BUSCAR COCHES POR MARCA
			case 5:

				System.out.println(" Introduzca la marca del vehiculo que quiere buscar");

				marca = sc.next();

				lista = gCoche.buscarPorMarca(marca);

				if (lista != null) {

					System.out.println("\n Listado de Vehiculos de la marca " + marca);
					for (Coche x : lista) {
						System.out.println("\n " + x.toString());
					}
					System.out.println("\n Fin del listado");

				} else
					System.out.println("\n Error de conexi�n con la BBDD");

				break;

			// BUSCAR COCHES POR MODELO
			case 6:

				System.out.println(" Introduzca el modelo del vehiculo que quiere buscar");

				modelo = sc.next();

				lista = gCoche.buscarPoModelo(modelo);

				if (lista != null) {

					System.out.println("\n Listado de Vehiculos del modelo " + modelo);
					for (Coche x : lista) {
						System.out.println("\n " + x.toString());
					}
					System.out.println("\n Fin del listado");

				} else
					System.out.println("\n Error de conexi�n con la BBDD");

				break;

			// BUSCAR COCHE POR MATRICULA
			case 7:

				System.out.println(" Introduzca la matr�cula del vehiculo que quiere buscar");

				matricula = sc.next();

				car = gCoche.buscarPoMatricula(matricula);

				if (car != null) {
					System.out.println("\n Vehiculo encontrado con �xito");
					System.out.println("\n " + car.toString());
				} else
					System.out.println("\n Error de conexi�n con la BBDD");

				break;

			// LISTAR COCHES
			case 8:

				lista = gCoche.listar();

				if (lista != null) {

					System.out.println("\n Listado de Vehiculos ");
					for (Coche x : lista) {
						System.out.println("\n " + x.toString());
					}
					System.out.println("\n Fin del listado");
				}

				else
					System.out.println("\n Error de conexi�n con la BBDD");

				break;

			// CONVERSION DE LA LISTA DE COCHES A UN FICHERO TXT EN FORMATO JSON
			case 9:

				lista = gCoche.listar();

				if (lista != null) {

					if (gCoche.crearTxtJson(lista))
						System.out.println(" Archivo creado con �xito");
					else
						System.out.println(" Error al crear el archivo");
				}

				else
					System.out.println("\n Error de conexi�n con la BBDD");

				break;

			// CONVERSION DE LA LISTA DE COCHES A UN FICHERO PDF
			case 10:

				// TODO PDF FILE
				lista = gCoche.listar();
				System.out.println("");

				if (gCoche.crearPDF(lista))
					System.out.println(" PDF creado con �xito");
				else
					System.out.println(" Error al crear el PDF");

				break;

			}

		} while (!exit);

		System.out.println("Fin de programa");

	}
	
	/**
	 * M�todo que se encarga de validar un usuario realizando una petici�n get al servicio web de validaci�n
	 * @param nombre nombre del usuario
	 * @param contrase�a contrase�a del usuario
	 * @return Devuelve un booleano, True en caso de validar con �xito el usuario, false en caso contrario
	 *  */
	private static boolean validarUsuario(String nombre, String contrase�a) {


			try {
				HttpRequest request = HttpRequest.newBuilder()
						.uri(new URI("http://localhost:8080/20_PROYECTO_JAVA_MAVEN_SERVICIO_WEB/usuarios/login?nombre="
								+ nombre + "&password=" + contrase�a))
						.GET().build();

				HttpClient client = HttpClient.newHttpClient();

				HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
				JSONObject json = new JSONObject(response.body());
				return json.getBoolean("validado");

			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			return false;
		

	}

	/**
	 * Metodo que se encarga de imprimir por pantalla el menu principal
	 * 
	 */
	private static void menu() {

		System.out.println("\n Elija una opci�n:");
		System.out.println(" 0- Salir del programa");
		System.out.println(" 1- Alta de Veh�culo");
		System.out.println(" 2- Baja de Veh�culo");
		System.out.println(" 3- Modificar Veh�culo");
		System.out.println(" 4- Buscar Veh�culo por Id");
		System.out.println(" 5- Buscar Veh�culo por Marca");
		System.out.println(" 6- Buscar Veh�culo por Modelo");
		System.out.println(" 7- Buscar Veh�culo por Matricula");
		System.out.println(" 8- Listar Veh�culos");
		System.out.println(" 9- Exportar los coches a un fichero en formato JSON");
		System.out.println(" 10- Exportar los coches a un fichero en formato PDF");

	}

}
