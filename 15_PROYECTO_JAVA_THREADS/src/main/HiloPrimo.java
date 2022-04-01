package main;

public class HiloPrimo implements Runnable{
	private int numero;
	
	// String name
		public HiloPrimo(int num,String nombreHilo) {
			this.numero = num;
			
			Thread t1 = new Thread(this,nombreHilo);
			t1.start();
		}

	@Override
	public void run() {
		
		if(esPrimo(this.numero)) System.out.println(Thread.currentThread().getName() + " es Primo");
		else System.out.println(Thread.currentThread().getName() + " no es Primo");
		
	}
	
	public boolean esPrimo(int numero) {
		
		  // El 0, 1 y 4 no son primos
		  if (numero == 0 || numero == 1 || numero == 4)  return false;
		  
		  for (int x = 2; x < numero / 2; x++) {
		    // Si es divisible por cualquiera de estos números, no
		    // es primo
		    if (numero % x == 0)return false;
		  }
		  
		  // Si no se pudo dividir por ninguno de los de arriba, sí es primo
		  return true;
		}

}
