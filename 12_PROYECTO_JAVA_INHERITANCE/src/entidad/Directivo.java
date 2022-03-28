package entidad;

import java.util.List;

public class Directivo extends Empleado {
	
	
	private List<Empleado> empleadosAdjuntos;
	
	public Directivo(String nombre, double sueldoBase, List<Empleado> empleadosAdjuntos) {
		super(nombre, sueldoBase);
		this.empleadosAdjuntos = empleadosAdjuntos;
	}
	
	public List<Empleado> getEmpleadosAdjuntos() {
		return empleadosAdjuntos;
	}
	public void setEmpleadosAdjuntos(List<Empleado> empleadosAdjuntos) {
		this.empleadosAdjuntos = empleadosAdjuntos;
	}
	
	
	@Override
	public void calcularSueldo() {
		// TODO Auto-generated method stub

	}

}
