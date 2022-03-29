package modelo.negocio;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {
	
private DaoCoche daoCoche = new DaoCocheMySQL();
	
	/**
	 * Metodo que da de alta un vehiculo en base de datos. La matrícula debe tener una longitud de 7 y el numero de kilometros no puede ser negativo
	 * @param c el vehiculo a dar de alta
	 * @return 0 en caso de que hayamos dado de alta el vehiculo, 1 en caso
	 * de algun error de conexión con la bbdd,2 en caso de que el coche no tenga exactamente 7 caracteres, 3 en caso de que los kilometros no sean positivos y
	 * 4 si tanto la matricula como los kilometros tienen errores
	 * 
	 */
	public int alta(Coche c){
	
		if(c.getMatricula().length() == 7 && c.getKilometros() >= 0) {
			
			boolean alta = daoCoche.alta(c);
			if(alta)return 0;
			else return 1;
			
		}
		
		else if(c.getKilometros()>= 0) {return 2;}
		else if(c.getMatricula().length() == 7) {return 3;}
		else return 4;
		
	}
	/**
	 * Metodo que se encarga de dar de baja un coche en la BBDD. En caso de error se imprimira por consola
	 * @param id Identificador del coche que se va a dar de baja ( tipo int )
	 * @return Devuelve 0 en caso de que se haya dado de baja el coche en la BBDD con éxito.1 en caso de que el coche no exista en la base de datos 2 en caso de error
	 * con la BBDD.
	 */
	public int baja(int id){
		int baja = daoCoche.baja(id);
		return baja;
	}
	
	/**
	 * Metodo que se encarga de dar de modificar un coche en la BBDD. En caso de error se imprimira por consola
	 * @param c Coche a modificar
	 * @return Devuelve 0 en caso de que se haya modificado el coche en la BBDD con éxito. Devuelve 1 en caso de que el coche no exista en la base de datos y devuelve 5 en caso de error
	 * con la BBDD.
	 */
	public int modificar(Coche c){
		
		if(c.getMatricula().length() == 7 && c.getKilometros() >= 0) {
			
			int modificar = daoCoche.modificar(c);
			return modificar;
			
		}
		
		else if(c.getKilometros()>= 0) {return 2;}
		else if(c.getMatricula().length() == 7) {return 3;}
		else return 4;
	}
	
	
}
