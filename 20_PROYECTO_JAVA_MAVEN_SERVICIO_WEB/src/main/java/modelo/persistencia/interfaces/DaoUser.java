package modelo.persistencia.interfaces;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.User;

public interface DaoUser {
	
	/**
	 * Metodo que se encarga de dar de alta un coche en la BBDD. En caso de error se imprimira por consola
	 * @param c Coche a dar de alta
	 * @return true en caso de que se haya dado de alta el coche en la BBDD con éxito. False en caso de error
	 * con la BBDD.
	 */
	boolean validar(User c);
	
	
}
