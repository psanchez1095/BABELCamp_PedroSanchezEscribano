package entidad;

public class Jefe extends Empleado {
	
	private Double incentivos;
	
	public Jefe(String nombre, double sueldoBase,double incentivos) {
		super(nombre, sueldoBase);
		this.incentivos = incentivos;
	}

	public double getIncentivos() {
		return incentivos;
	}
	public void setIncentivos(double incentivos) {
		this.incentivos = incentivos;
	}
	
	public void calcularSueldo() {
		// TODO Auto-generated method stub

	}

}
