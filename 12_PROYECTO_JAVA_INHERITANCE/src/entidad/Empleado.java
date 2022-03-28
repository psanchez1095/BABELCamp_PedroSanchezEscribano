package entidad;

public abstract class Empleado {
	private String nombre;
	private double sueldoBase;

	/**
	 * Metodo abstracto que se encarga de calcular el sueldo en funcion de cada empleado
	 * @return Devuelve un tipo double que sera el sueldo ya calculado
	 */
	public abstract double calcularSueldo();

	public Empleado(String nombre, double sueldoBase) {
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
		
}
