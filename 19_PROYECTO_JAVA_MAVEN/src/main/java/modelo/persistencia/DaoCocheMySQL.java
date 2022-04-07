package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySQL implements DaoCoche {

	private Connection conexion;

	/**
	 * Metodo que se encarga crear la conexión con la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @return true en caso de que se haya la conexión se haya creado con exito.
	 *         False en caso de error con la BBDD.
	 */
	public boolean nuevaConexion() {

		String url = "jdbc:mysql://localhost:3306/empresacoches";
		String usuario = "root";
		String password = "";

		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo que se encarga de cerra la conexión con la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @return true en caso de que se haya la conexión se haya cerrado con exito.
	 *         False en caso de error con la BBDD.
	 */
	public boolean cerrarConexion() {

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

		if (!nuevaConexion())
			return false;

		boolean alta = true;

		String query = "insert into coches (MATRICULA,MARCA,MODELO,NUMEROKILOMETROS) " + " values(?,?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKilometros());

			int numeroFilasAfectadas = ps.executeUpdate();

			if (numeroFilasAfectadas == 0) {
				alta = false;
			}

		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
		} finally {
			cerrarConexion();
		}
		return alta;
	}

	@Override
	public int baja(int id) {

		if (!nuevaConexion())
			return 2;

		int baja = 0;
		String query = "delete from coches where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustituimos la primera interrgante por la id
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				baja = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return baja;

	}

	@Override
	public int modificar(Coche c) {

		if (!nuevaConexion())
			return 5;

		int modificar = 0;

		String query = "update coches set MATRICULA=?, MARCA=?, " + "MODELO=?,NUMEROKILOMETROS=? WHERE ID=?";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);

			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKilometros());
			ps.setInt(5, c.getId());

			int numeroFilasAfectadas = ps.executeUpdate();

			if (numeroFilasAfectadas == 0)
				modificar = 1;

		} catch (SQLException e) {
			modificar = 1;
		} finally {
			cerrarConexion();
		}
		return modificar;
	}

	@Override
	public Coche buscarPorId(int id) {
		if (!nuevaConexion()) {
			return null;
		}
		Coche c = null;

		String query = "select ID,MATRICULA,MODELO,MARCA,NUMEROKILOMETROS from coches " + "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				c.setKilometros(rs.getDouble(5));

			}
		} catch (SQLException e) {
			System.out.println("Buscar por Id -> error al obtener la " + "persona con id " + id);
		} finally {
			cerrarConexion();
		}

		return c;
	}

	@Override
	public ArrayList<Coche> buscarPorMarca(String marca) {
		if (!nuevaConexion()) {
			return null;
		}
		Coche c = null;

		String query = "select ID,MATRICULA,MODELO,MARCA,NUMEROKILOMETROS from coches " + "where marca = ?";
		ArrayList<Coche> lista = new ArrayList<Coche>();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, marca);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
				lista.add(c);

			}
		} catch (SQLException e) {
			System.out.println("Buscar por marca -> error al obtener la " + "persona con marca " + marca);
		} finally {
			cerrarConexion();
		}

		return lista;
	}

	@Override
	public ArrayList<Coche> buscarPorModelo(String modelo) {
		if (!nuevaConexion()) {
			return null;
		}
		Coche c = null;

		String query = "select ID,MATRICULA,MODELO,MARCA,NUMEROKILOMETROS from coches " + "where modelo = ?";
		ArrayList<Coche> lista = new ArrayList<Coche>();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, modelo);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
				lista.add(c);

			}
		} catch (SQLException e) {
			System.out.println("Buscar por modelo -> error al obtener la " + "persona con modelo " + modelo);
		} finally {
			cerrarConexion();
		}

		return lista;
	}

	@Override
	public Coche buscarPorMatricula(String matricula) {
		if (!nuevaConexion()) {
			return null;
		}
		Coche c = null;

		String query = "select ID,MATRICULA,MODELO,MARCA,NUMEROKILOMETROS from coches " + "where matricula = ?";
		ArrayList<Coche> lista = new ArrayList<Coche>();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setMarca(rs.getString(4));
				c.setKilometros(rs.getDouble(5));

			}
		} catch (SQLException e) {
			System.out.println("Buscar por matrícula -> error al obtener la " + "vehículo con matrícula " + matricula);
		} finally {
			cerrarConexion();
		}

		return c;
	}

	@Override
	public ArrayList<Coche> listar() {
		if (!nuevaConexion()) {
			return null;
		}
		Coche c = null;

		String query = "select * from coches ";
		ArrayList<Coche> lista = new ArrayList<Coche>();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
				lista.add(c);

			}
		} catch (SQLException e) {
			System.out.println("Listar vehículos > error al obtener los vehículos");

		} finally {
			cerrarConexion();
		}
		
		return lista;
	}

}
