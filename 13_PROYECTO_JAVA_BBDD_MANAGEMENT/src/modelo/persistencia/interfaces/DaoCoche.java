package modelo.persistencia.interfaces;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {
	
	/**
	 * Metodo que se encarga de dar de alta un coche en la BBDD. En caso de error se imprimira por consola
	 * @param c Coche a dar de alta
	 * @return true en caso de que se haya dado de alta el coche en la BBDD con ?xito. False en caso de error
	 * con la BBDD.
	 */
	boolean alta(Coche c);
	
	/**
	 * Metodo que se encarga de dar de baja un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Identificador del coche que se va a dar de baja ( tipo int )
	 * @return Devuelve 0 en caso de que se haya dado de baja el coche en la BBDD con ?xito.1 en caso de que el coche no exista en la base de datos 2 en caso de error
	 * con la BBDD.
	 */
	int baja(int id);
	
	/**
	 * Metodo que se encarga de dar de modificar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param c Coche a modificar
	 * @return Devuelve 0 en caso de que se haya modificado el coche en la BBDD con ?xito. Devuelve 1 en caso de que el coche no exista en la base de datos y devuelve 5 en caso de error
	 * con la BBDD.
	 */
	int modificar(Coche c);
	
	/**
	 * Metodo que se encarga de dar de buscar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Identificador del coche que se va a buscar ( tipo int )
	 * @return true en caso de que se haya encontrado el coche en la BBDD con ?xito. False en caso de error
	 * con la BBDD.
	 */
	Coche buscarPorId(int id);
	
	/**
	 * Metodo que se encarga de dar de buscar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Marca del coche que se va a buscar ( tipo String )
	 * @return Devuelve un objeto de tipo Coche en caso de ?xito. null en caso contrario
	 */
	ArrayList<Coche> buscarPorMarca(String marca);
	
	/**
	 * Metodo que se encarga de dar de buscar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Modelo del coche que se va a buscar ( tipo String )
	 * @return Devuelve un objeto de tipo Coche en caso de ?xito. null en caso contrario
	 */
	ArrayList<Coche> buscarPorModelo(String modelo);
	
	/**
	 * Metodo que se encarga de dar de buscar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Matr?cula del coche que se va a buscar ( tipo String )
	 * @return Devuelve un objeto de tipo Coche en caso de ?xito. null en caso contrario
	 */
	Coche buscarPorMatricula(String matricula);
	
	/**
	 * Metodo que se encarga de dar de buscar un coche en la BBDD. En caso de error se imprimira por consola.
	 * @return Devuelve un List de objetos de la clase Coche en caso de ?xito. null en caso de error.
	 */
	ArrayList<Coche> listar();

	

}
