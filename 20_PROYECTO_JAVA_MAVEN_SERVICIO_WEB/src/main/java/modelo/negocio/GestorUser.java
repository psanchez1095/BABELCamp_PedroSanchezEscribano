package modelo.negocio;

import modelo.entidad.User;
import modelo.persistencia.DaoUserMySQL;
import modelo.persistencia.interfaces.DaoUser;

public class GestorUser {

	private DaoUser daoUser = new DaoUserMySQL();

	/**
	 * Metodo que se encarga de validar un usuario mediante su nombre y contraseña.
	 * 
	 * @param user usuario a validar
	 * @return true en caso de que exista dicho usuario en la BBDD False en caso de
	 *         que no se encuentre el usuario en la BBDD o en caso de error con la
	 *         BBDD
	 */
	public boolean validar(User user) {

		if (user.getPassword().equals("") || user.getNombre().equals(""))
			return false;

		user = daoUser.buscarUsuarioPorNombreContrasenia(user);
		if (!user.getNombre().equals("") && !user.getPassword().equals(""))
			return true;
		return false;

	}

}
