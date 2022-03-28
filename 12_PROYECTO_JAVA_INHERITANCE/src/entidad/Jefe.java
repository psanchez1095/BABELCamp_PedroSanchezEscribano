package entidad;

public class Jefe extends Empleado {
	
	public static String puesto= "Jefe";
	
	private double incentivos;
	
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
	
	public double calcularSueldo() {
		return this.getSueldoBase() + this.incentivos;

	}
	

}
