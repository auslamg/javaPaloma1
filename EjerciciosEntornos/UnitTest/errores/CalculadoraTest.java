package errores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma() {
		Calculadora c = new Calculadora(1,2);
		
		if (c.suma() != 3) {
			fail("Suma no funciona");	
		}
	}

	@Test
	void testResta() {
		Calculadora c = new Calculadora(2,1);
		
		if (c.resta() != 1) {
			fail("Resta no funciona");			
		}
	}

	@Test
	void testProducto() {
		Calculadora c = new Calculadora(2,3);
		
		if (c.producto() != 6) {
			fail("Producto no funciona");		
		}
	}

	@Test
	void testDivision() {
		Calculadora c = new Calculadora(4,2);
		
		if (c.division() != 2) {
			fail("Division no funciona");		
		}
	}

}
