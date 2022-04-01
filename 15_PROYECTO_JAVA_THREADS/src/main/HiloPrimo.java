package main;

public class HiloPrimo implements Runnable,InterfacePrimo{
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
	


}
