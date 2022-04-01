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
		
		int i = 1;
		
		for(int x : listaPosiblesPrimos) {
			new HiloPrimo(x,"Hilo"+i);
			i++;
		}
		
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

}
