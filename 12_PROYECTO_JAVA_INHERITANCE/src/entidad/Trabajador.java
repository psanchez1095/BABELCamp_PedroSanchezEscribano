package entidad;

public class Trabajador extends Empleado {
	
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
	public void calcularSueldo() {
		// TODO Auto-generated method stub

	}
	
	
}
