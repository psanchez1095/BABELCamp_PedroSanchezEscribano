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
	
<<<<<<< HEAD
	//Cambios rama restaBranch
	int doSpezialAcum(final int n) {
		this.acum-=n;
		this.acum-=10;
		return this.acum%10;
	}
=======
	//Funcion doSpezialAcum eliminado
	
>>>>>>> c5f7ba4cb7ad0f0668ef61d64aac07c2c1a66969
	
}
