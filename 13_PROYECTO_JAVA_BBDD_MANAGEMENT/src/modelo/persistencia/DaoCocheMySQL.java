package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		if(!nuevaConexion())return false;
		
		boolean alta = true;
		
		String query = "insert into coches (MATRICULA,MARCA,MODELO,NUMEROKILOMETROS) "
				+ " values(?,?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3,c.getModelo());
			ps.setDouble(4,c.getKilometros());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " +c);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return alta;
	}

	@Override
	public int baja(int id) {

		if(!nuevaConexion())return 2;
		
		int baja = 0;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) baja = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return baja; 
		
	}

	@Override
	public int modificar(Coche c) {

		if(!nuevaConexion())return 5;
		
		int modificar = 0;
		
		String query = "update coches set MATRICULA=?, MARCA=?, "
				+ "MODELO=?,NUMEROKILOMETROS=? WHERE ID=?";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3,c.getModelo());
			ps.setDouble(4,c.getKilometros());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			
			if(numeroFilasAfectadas == 0) modificar = 1;
			
			
		} catch (SQLException e) {
			modificar = 1;
		} finally{
			cerrarConexion();
		}
		return modificar;
	}

	@Override
	public Coche buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Coche> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Coche> buscarPorModelo(String modelo) {
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
