package git_00;


public class Suma {
	int acum; //Atributo que guarda un entero que es el resultado de acumular sumas
	
	public Suma() {
		this.acum = 0;
	}
	
	int suma(final int a,final int b) {
		return a+b;
	}
	
	int doAcum(final int n) {
		this.acum+=n;
		return this.acum;
	}
}
