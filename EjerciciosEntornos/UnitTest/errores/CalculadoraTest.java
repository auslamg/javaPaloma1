package errores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma() {
		Calculadora c = new Calculadora(1,2);
		int resultado = c.suma();

		assertEquals(resultado, 3);
	}

	@Test
	void testResta() {
		Calculadora c = new Calculadora(2,1);
		int resultado = c.resta();

		assertEquals(resultado, 1);
	}

	@Test
	void testProducto() {
		Calculadora c = new Calculadora(2,3);
		int resultado = c.producto();

		assertEquals(resultado, 6);
		
	}

	@Test
	void testDivision() {
		Calculadora c = new Calculadora(4,2);
		int resultado = c.division();

		assertEquals(resultado, 2);
	}

}
