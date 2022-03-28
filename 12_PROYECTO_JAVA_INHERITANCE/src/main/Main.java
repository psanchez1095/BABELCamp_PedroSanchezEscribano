package main;

import java.util.ArrayList;
import java.util.List;

import entidad.Directivo;
import entidad.Empleado;
import entidad.Jefe;
import entidad.Trabajador;

public class Main {

	public static void main(String[] args) {
		
		List<Empleado> empleados =  new ArrayList<Empleado>();
		//Añadimos tres trabajadores
		Empleado emp = new Trabajador("Connor",25000.2,8);
		empleados.add(emp);
		emp = new Trabajador("Steven",22000.2,6);
		empleados.add(emp);
		emp = new Trabajador("Jessy",14322.28,5);
		empleados.add(emp);

		//Añadimos dos jefes
		emp = new Jefe("Stuart",34000.7,1333);
		empleados.add(emp);
		emp = new Jefe("Dolly",36087.7,666);
		empleados.add(emp);
		
		//Añadimos un directivo
		
		//Creamos lista de empleados para el directivo
		List<Empleado> empDirectivo =  new ArrayList<Empleado>();
		empDirectivo.add(empleados.get(0));
		empDirectivo.add(empleados.get(2));
		empDirectivo.add(empleados.get(3));
		
		emp = new Directivo("Elon",53888.5,empDirectivo);
		empleados.add(emp);
		
		
		//SALIDA POR CONSOLA
		System.out.print("Listado Sueldos: \n\n");
		
		for(Empleado x : empleados) {
			System.out.print("Empleado " + x.getNombre() + " \n");
			System.out.print("Sueldo Anual : \n" +x.calcularSueldo() + " \n\n");

		}
		
	}

}
