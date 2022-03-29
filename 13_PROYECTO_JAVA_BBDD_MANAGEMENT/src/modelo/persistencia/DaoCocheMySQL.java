package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySQL implements DaoCoche{
		
	private Connection conexion;
	
	/**
	 * Metodo que se encarga crear la conexión con la BBDD. En caso de error se imprimira por consola
	 * @return true en caso de que se haya la conexión se haya creado con exito. False en caso de error
	 * con la BBDD.
	 */
	public boolean nuevaConexion(){
		
		String url = "jdbc:mysql://localhost:3306/empresacoches";
		String usuario = "root";
		String password = "";
		
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		System.out.print("bien");
		return true;
	}
	
	/**
	 * Metodo que se encarga de cerra la conexión con la BBDD. En caso de error se imprimira por consola
	 * @return true en caso de que se haya la conexión se haya cerrado con exito. False en caso de error
	 * con la BBDD.
	 */
	public boolean cerrarConexion(){
		
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	@Override
	public boolean alta(Coche c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean baja(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(int c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coche buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche buscarPorModelo(String modelo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coche> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
