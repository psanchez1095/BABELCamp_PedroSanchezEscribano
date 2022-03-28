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
		Empleado emp = new Trabajador("Connor",1450.2,8);
		empleados.add(emp);
		emp = new Trabajador("Steven",1600.2,6);
		empleados.add(emp);
		emp = new Trabajador("Jessy",1432.28,5);
		empleados.add(emp);

		//Añadimos dos jefes
		emp = new Jefe("Stuart",3400.55,1333);
		empleados.add(emp);
		emp = new Jefe("Dolly",3608.7,666);
		empleados.add(emp);
		
		//Añadimos un directivo
		
		//Creamos lista de empleados para el directivo
		List<Empleado> empDirectivo =  new ArrayList<Empleado>();
		empDirectivo.add(empleados.get(0));
		empDirectivo.add(empleados.get(2));
		empDirectivo.add(empleados.get(3));
		
		emp = new Directivo("Elon",5388.5,empDirectivo);
		empleados.add(emp);
		
		
		//SALIDA POR CONSOLA
		System.out.print(" \nListado Sueldos \n\n");
			
		/*for(Empleado x : empleados) {
			System.out.print(" - Empleado " + x.getNombre() + " \n");
			System.out.print("   Sueldo Final : \n   " +x.calcularSueldo() + " \n\n");
		}*/
		
		for(int i = 0; i< empleados.size();i++) {
			
			//Imprimimos el tipo de empleado
			if(empleados.get(i) instanceof Directivo) System.out.print(" - Empleado " +Directivo.puesto);
			else if(empleados.get(i) instanceof Jefe) System.out.print(" - Empleado " +Jefe.puesto);
			else System.out.print(" - Empleado " +Trabajador.puesto);
			
			//Imprimimos el nombre
			System.out.print(" " + empleados.get(i).getNombre() + " \n");
			
			//Imprimimos el sueldo final
			System.out.print("   Sueldo Final : \n   " +empleados.get(i).calcularSueldo() + " \n\n");
			
		}
			
		System.out.print("Fin del Listado \n");
	}

}
