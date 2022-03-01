package git_00;

public class Resta {
int acum; //Atributo que guarda un entero que es el resultado de acumular sumas
	
	public Resta() {
		this.acum = 0;
	}
	
	int resta(final int a,final int b) {
		return a-b;
	}
	
	int doAcum(final int n) {
		this.acum-=n;
		return this.acum;
	}
}
