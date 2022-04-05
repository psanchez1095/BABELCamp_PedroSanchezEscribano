package main;

public class Main {

	public static void main(String[] args) {
	
		InterfazGenericOperation<Integer> interfazSuma = (x,y) -> x+y;
		InterfazGenericOperation<Integer> interfazResta = (x,y) -> x-y;
		InterfazGenericOperation<Integer> interfazDivision = (x,y) -> x/y;
		InterfazGenericOperation<Integer> interfazMultiplicacion = (x,y) -> x*y;
		
		InterfazGenericOperation<Double> interfazSumaDou = (x,y) -> x+y;
		InterfazGenericOperation<Double> interfazRestaDou = (x,y) -> x-y;
		InterfazGenericOperation<Double> interfazDivisionDou = (x,y) -> x/y;
		InterfazGenericOperation<Double> interfazMultiplicacionDou = (x,y) -> x*y;
		
		InterfazGenericOperation<String> interfazConcatenaStr = (str1,str2) -> str1+str2;
		
		InterfazGenericOperation<Boolean> interfazAnalizaBooleans= (b1,b2) -> {
			if(!b1 || !b2) return false;
			else return true;
		}	;
		
		System.out.println("\n   Suma Enteros");
		System.out.println("   "+interfazSuma.operation(10, 2));
		System.out.println("   Resta Enteros");
		System.out.println("   "+interfazResta.operation(10, 2));
		System.out.println("   División Enteros");
		System.out.println("   "+interfazDivision.operation(10, 2));
		System.out.println("   Multiplicación Enteros");
		System.out.println("   "+interfazMultiplicacion.operation(10, 2));
		
		System.out.println("\n   Suma Doubles");
		System.out.println("   "+interfazSumaDou.operation(10.2, 3.2));
		System.out.println("   Resta Doubles");
		System.out.println("   "+interfazRestaDou.operation(10.2, 3.2));
		System.out.println("   División Doubles");
		System.out.println("   "+interfazDivisionDou.operation(10.2, 3.2));
		System.out.println("   Multiplicación Doubles");
		System.out.println("   "+interfazMultiplicacionDou.operation(10.2, 3.2));
		
		System.out.println("\n   Concatena Cadenas");
		System.out.println("   "+interfazConcatenaStr.operation("Pedro","Sanchez"));
		
	}

}
