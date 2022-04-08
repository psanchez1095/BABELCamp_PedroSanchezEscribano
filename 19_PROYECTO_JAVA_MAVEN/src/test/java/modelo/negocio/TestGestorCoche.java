package modelo.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;

class TestGestorCoche {

	@Test
	void testConvertirJSON() {
		
		GestorCoche gc = new GestorCoche();
		Coche c = new Coche(1,"qwerty22","SEAT","TOLEDO",1234.5);

		assertNotNull(c);
		assertNotSame("",gc.convertirAJson(c));

	}
	
	@Test
	void testBuscarPorId() {
		
		GestorCoche gc = new GestorCoche();
		int id = 1;
		assert(gc.buscarPorId(id)==null || gc.buscarPorId(id) instanceof Coche);
		id = 10000;
		assert(gc.buscarPorId(id)==null || gc.buscarPorId(id) instanceof Coche);

	}
	
}
