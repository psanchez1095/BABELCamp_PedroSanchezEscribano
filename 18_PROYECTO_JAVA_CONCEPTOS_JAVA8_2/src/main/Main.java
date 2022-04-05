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
		
		//TODO USAR INTERFACES
		
	}

}
