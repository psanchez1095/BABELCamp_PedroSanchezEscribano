package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		boolean exit = false;
		
		do {
		
		System.out.println("\n    ----IDENTIFICADOR DE NUMEROS PRIMOS----");
		System.out.println("     ¿Cuantos números desea introducir? ");
		System.out.println("\n\n                             Pulse 0 para salir");
		Scanner in = new Scanner(System.in);
		int cantidadNum = in.nextInt();
		
		if(cantidadNum==0) {
			exit=true;
			break;
		}
		
		ArrayList<Integer> listaPosiblesPrimos = new ArrayList<Integer>();
		
		for(int i=0;i<cantidadNum;i++) {
			System.out.println("   - Introduce un número ");
			listaPosiblesPrimos.add(in.nextInt());
		}
	
		//USO FUNCION LAMBDA
		NumeroPrimo primo = numero ->{
			
			boolean esPrimo=true;
			
			//revisa si n es multiplo de 2
		    if (numero%2==0) esPrimo= false;
		    //si no, solo revisa los impares
		    for(int i=3;i*i<=numero;i+=2) {
		        if(numero%i==0) esPrimo= false;
		    }
		    
		    if(esPrimo) System.out.println(numero + " es Primo");
			else System.out.println(numero + " no es Primo");
		    
			return null;
			
			
		};
		//USO FUNCION LAMBDA
		listaPosiblesPrimos.forEach(x->primo.identificaPrimo(x));
			
		
		//Espera al calculo de los hilos 2 segundos
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}while(!exit);
		System.out.println("\n           ----FIN DEL PROGRAMA----");
	}
	
	@FunctionalInterface
	interface NumeroPrimo {
		Runnable identificaPrimo(int numero);
	}
	

}
