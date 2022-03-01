package git_00;

import java.util.Scanner;

public class Main {

		public static void main(String[] args) {

			Suma s = new Suma();
			Scanner scan=new Scanner(System.in);
			System.out.print("Ingresa dos numeros para la suma y la suma acumulada:\n");
			
			int a=Integer.parseInt(scan.next());
			int b=Integer.parseInt(scan.next());
			
			System.out.print("La suma es "+s.suma(a, b)+"\n");
			System.out.print("La suma acumlada es " +s.doAcum(a)+"\n");
			System.out.print("La suma acumlada es " +s.doAcum(b)+"\n");
				
		}

	}

