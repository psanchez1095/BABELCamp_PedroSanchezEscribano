package modelo.persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.entidad.User;
import modelo.persistencia.interfaces.DaoUser;

public class DaoUserMySQL implements DaoUser {

	private Connection conexion;

	/**
	 * Metodo que se encarga crear la conexión con la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @return true en caso de que se haya la conexión se haya creado con exito.
	 *         False en caso de error con la BBDD.
	 * @throws ClassNotFoundException 
	 */
	public boolean nuevaConexion() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
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

	public boolean validar(User c) {

		try {
			if (!nuevaConexion()) {
				return false;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String query = "select NOMBRE,PASSWORD from usuarios " + "where nombre = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getNombre());
			

			ResultSet rs = ps.executeQuery();
			User aux = new User();
			while (rs.next()) {
				
				aux.setNombre(rs.getString(1));
				aux.setPassword(rs.getString(2));
			}
			if(c.getPassword().equals(aux.getPassword())) return true;
			
		} catch (SQLException e) {
			System.out.println("Buscar por Id -> error al obtener la " + "persona con id ");
		} finally {
			cerrarConexion();
		}

		return true;
		
		
	}

	

}
