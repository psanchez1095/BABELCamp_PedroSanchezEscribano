package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;
import com.google.gson.Gson;

public class GestorCoche {

	private DaoCoche daoCoche = new DaoCocheMySQL();

	/**
	 * Metodo que da de alta un vehiculo en base de datos. La matrícula debe tener
	 * una longitud de 7 y el numero de kilometros no puede ser negativo
	 * 
	 * @param c el vehiculo a dar de alta
	 * @return 0 en caso de que hayamos dado de alta el vehiculo, 1 en caso de algun
	 *         error de conexión con la bbdd,2 en caso de que el coche no tenga
	 *         exactamente 7 caracteres, 3 en caso de que los kilometros no sean
	 *         positivos y 4 si tanto la matricula como los kilometros tienen
	 *         errores
	 * 
	 */
	public int alta(Coche c) {

		if (c.getMatricula().length() == 7 && c.getKilometros() >= 0) {

			boolean alta = daoCoche.alta(c);
			if (alta)
				return 0;
			else
				return 1;

		}

		else if (c.getKilometros() >= 0) {
			return 2;
		} else if (c.getMatricula().length() == 7) {
			return 3;
		} else
			return 4;

	}

	/**
	 * Metodo que se encarga de dar de baja un coche en la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @param id Identificador del coche que se va a dar de baja ( tipo int )
	 * @return Devuelve 0 en caso de que se haya dado de baja el coche en la BBDD
	 *         con éxito.1 en caso de que el coche no exista en la base de datos 2
	 *         en caso de error con la BBDD.
	 */
	public int baja(int id) {
		int baja = daoCoche.baja(id);
		return baja;
	}

	/**
	 * Metodo que se encarga de dar de modificar un coche en la BBDD. En caso de
	 * error se imprimira por consola
	 * 
	 * @param c Coche a modificar
	 * @return Devuelve 0 en caso de que se haya modificado el coche en la BBDD con
	 *         éxito. Devuelve 1 en caso de que el coche no exista en la base de
	 *         datos y devuelve 5 en caso de error con la BBDD.
	 */
	public int modificar(Coche c) {

		if (c.getMatricula().length() == 7 && c.getKilometros() >= 0) {

			int modificar = daoCoche.modificar(c);
			return modificar;

		}

		else if (c.getKilometros() >= 0) {
			return 2;
		} else if (c.getMatricula().length() == 7) {
			return 3;
		} else
			return 4;
	}

	/**
	 * Metodo que se encarga de obtener un vehículo de la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @param id Identificador del coche a buscar
	 * @return Devuelve una referencia del tipo Coche si se obtuvo con éxito el
	 *         coche de la BBDD Devuelve null en caso de error con la BBDD
	 */
	public Coche buscarPorId(int id) {
		Coche c = daoCoche.buscarPorId(id);
		return c;
	}

	/**
	 * Metodo que se encarga de obtener un vehículo de la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @param marca marca del coche a buscar
	 * @return Devuelve una referencia del tipo Coche si se obtuvo con éxito el
	 *         coche de la BBDD Devuelve null en caso de error con la BBDD
	 */
	public ArrayList<Coche> buscarPorMarca(String marca) {
		ArrayList<Coche> lista = daoCoche.buscarPorMarca(marca);
		return lista;
	}

	/**
	 * Metodo que se encarga de obtener un vehículo de la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @param modelo modelo del coche a buscar
	 * @return Devuelve una referencia del tipo Coche si se obtuvo con éxito el
	 *         coche de la BBDD Devuelve null en caso de error con la BBDD
	 */
	public ArrayList<Coche> buscarPoModelo(String modelo) {
		ArrayList<Coche> lista = daoCoche.buscarPorModelo(modelo);
		return lista;
	}

	/**
	 * Metodo que se encarga de obtener un vehículo de la BBDD. En caso de error se
	 * imprimira por consola
	 * 
	 * @param matricula matricula del coche a buscar
	 * @return Devuelve una referencia del tipo Coche si se obtuvo con éxito el
	 *         coche de la BBDD Devuelve null en caso de error con la BBDD
	 */
	public Coche buscarPoMatricula(String matricula) {
		Coche c = daoCoche.buscarPorMatricula(matricula);
		return c;
	}

	/**
	 * Metodo que se encarga de obtener la lista de todos los vehículos de la BBDD.
	 * En caso de error se imprimira por consola
	 * 
	 * @return Devuelve un ArrayList de Coches si se obtuvo con éxito la lista de la
	 *         BBDD Devuelve null en caso de error con la BBDD
	 */
	public ArrayList<Coche> listar() {
		ArrayList<Coche> lista = daoCoche.listar();
		return lista;
	}

	/**
	 * Metodo que se encarga de convertir una referencia de un objeto de tipo coche
	 * a JSON
	 * 
	 * @param c es una referencia del tipo coche que se va a convertir a JSON
	 * @return Devuelve un String en formato JSON de Coche si se pudo convertir el
	 *         Coche a JSON
	 */
	public String convertirAJson(Coche c) {
		Gson gson = new Gson();
		String json = gson.toJson(c);
		return json;
	}

}
