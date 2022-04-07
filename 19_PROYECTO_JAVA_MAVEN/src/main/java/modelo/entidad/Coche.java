package modelo.entidad;

public class Coche {

	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private double kilometros;

	public Coche(int id, String matricula, String marca, String modelo, double kilometros) {
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometros = kilometros;
	}

	public Coche() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", kilometros=" + kilometros + "]";
	}

}
