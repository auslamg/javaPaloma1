package errores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	private Calculadora c;
	
	@BeforeEach
	void InicializarCalculadora() {
		c = new Calculadora(10,2);
	}
	
	@Test
	void testSuma() {
		int resultado = c.suma();

		assertEquals(resultado, 12);
	}

	@Test
	void testResta() {
		int resultado = c.resta();

		assertEquals(resultado, 8);
	}

	@Test
	void testProducto() {
		int resultado = c.producto();

		assertEquals(resultado, 20);	
	}

	@Test
	void testDivision() {
		int resultado = c.division();

		assertEquals(resultado, 5);
	}
	
	@AfterAll
	static void finTest() {
		System.out.println("Test ‘Calculadora.java’ finalizado - Gabriel Ausejo Lamadrid");
	}
}
