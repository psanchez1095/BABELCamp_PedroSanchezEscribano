package entidad;

public class Trabajador extends Empleado {
	
	public static String puesto= "Trabajador";
	
	private int valoracion;
	
	public Trabajador(String nombre, double sueldoBase, int valoracion) {
		super(nombre, sueldoBase);
		this.valoracion = valoracion;
	}


	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	

	@Override
	public double calcularSueldo() {
		
		int extra;
		
		if(this.valoracion<0 || this.valoracion > 10) extra = 0;
		else if(this.valoracion < 5 ) extra = 0;
		else if(this.valoracion < 7 ) extra = 50;
		else if(this.valoracion < 9 ) extra = 100;
		else extra = 200;
		
		return this.getSueldoBase() + extra;
	}
	
	
}
