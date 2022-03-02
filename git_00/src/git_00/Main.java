package git_00;

import java.util.Scanner;

public class Main {

		public static void main(String[] args) {

			Suma s = new Suma();
			Resta r = new Resta();
			Scanner scan=new Scanner(System.in);
			System.out.print("Ingresa dos numeros para realizar las operaciones de suma y resta:\n");
			
			int a=Integer.parseInt(scan.next());
			int b=Integer.parseInt(scan.next());
			
			System.out.print("La suma es "+s.suma(a, b)+"\n");
			System.out.print("La suma acumlada es " +s.doAcum(a)+"\n");
			System.out.print("La suma acumlada es " +s.doAcum(b)+"\n\n");
			
			System.out.print("La resta es "+r.resta(a, b)+"\n");
			System.out.print("La resta acumlada es " +r.doAcum(a)+"\n");
			System.out.print("La resta acumlada es " +r.doAcum(b)+"\n");
			

			//Cambio para merge de tres vias sin conflicto
			System.out.print("Cambios Master");
			//Cambio para merge de tres vias con conflicto
			System.out.print("Resultado post conflicto de tres vias");
				

			
			

		}

	}

