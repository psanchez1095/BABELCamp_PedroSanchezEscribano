package modelo.persistencia.interfaces;

import modelo.entidad.User;

public interface DaoUser {
	
	/**
	 * Metodo que se encarga de buscar un usuario en la base de datos mediante su nombre y contraseña.
	 * @param user usuario a buscar en la BBDD
	 * @return Devuelve un objeto user, en caso de que este usuario no se encuentre en la base de datos o exista algun error de conexion
	 * sus campos de nombre y contraseña seran ""
	 */
	User buscarUsuarioPorNombreContrasenia(User user);
	
	
}
