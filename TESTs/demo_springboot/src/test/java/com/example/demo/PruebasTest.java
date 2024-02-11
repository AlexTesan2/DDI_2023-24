package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.example.demo.Pruebas.MiExcepcion;
import com.example.demo.model.Student;

@ExtendWith(MockitoExtension.class)
class PruebasTest {

	Pruebas pr = new Pruebas();

	@Test
	void sumaNormal() {
		int resultadoEsperado = 10;
		int resultadoReal = pr.sumar(4, 6);
		assertEquals(resultadoReal, resultadoEsperado);
	}

	@Test
	void sumaUsandoUnNumNegativo() {
		int resultadoEsperado = -2;
		int resultadoReal = pr.sumar(4, -6);
		assertEquals(resultadoReal, resultadoEsperado);
	}

	@Test
	void divisionDeDosNumerosEnterosSiendoElDividiendoElMayor() {
		int dividendo = 20;
		int divisor = 5;
		double resultadoEsperado = 4; // dividendo / divisor
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionDeDosNumerosEnterosSiendoElDividiendoElMenor() {
		double dividendo = 1;
		double divisor = 2;
		double resultadoEsperado = 0.5;
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionElDividiendoEsNegativoTest() {
		double dividendo = -6;
		double divisor = 2;
		double resultadoEsperado = -3;
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionElDivisorEsNegativoTest() {
		double dividendo = 6;
		double divisor = -2;
		double resultadoEsperado = -3;
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionDeDosNumNegativosTest() {
		double dividendo = -6;
		double divisor = -2;
		double resultadoEsperado = 3;
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionSiendoElDividiendoCero() {
		double dividendo = 0;
		double divisor = 2;
		double resultadoEsperado = 0;
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionSiendoElDivisorCero() {
		double dividendo = 5;
		double divisor = 0;
		char resultadoEsperado = '∞';
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void divisionSiendoAmbosNumerosCero() {
		double dividendo = 0;
		double divisor = 0;
		char resultadoEsperado = '∞';
		assertEquals(resultadoEsperado, pr.dividir(dividendo, divisor));
	}

	@Test
	void testDividirASecasNoEsperoErroesTest() {
		assertEquals(5, pr.dividirASecas(10, 2));
	}


	@Test
	public void testDividirASecasSiendoDivisoCero() {
		double resultado = pr.dividirASecas(5, 0);
		assertEquals(Double.POSITIVE_INFINITY, resultado);
	}

	@Test
	public void testExcepcion() {

		assertThrows(NullPointerException.class, () -> {
			pr.metodoQueLanzaExcepcion(4);
		}, "Se esperaba que el método lanzara una NullPointerException");
	}

	@Test
	public void testExcepcionGenenrica() {

		assertThrows(Exception.class, () -> {
			pr.metodoQueLanzaExcepcion(4);
		}, "Se esperaba que el método lanzara una excepción generica");
	}

	@Test
	public void testMetodoQueNoLanzaExcepcion() {

		assertDoesNotThrow(() -> pr.metodoQueLanzaExcepcion(6),
				"Se esperaba que el método no lanzara ninguna excepción");
	}


	@Test
	public void testMetodoQueLanzaExcepcionCreadaPorMi() {
		assertThrows(MiExcepcion.class, () -> {
			pr.metodoQueLanzaExcepcionCreadaPorMi();
		}, "Frase en caso de que falle");
	}


	@Test
	void ReturnFraseTesteo() {
		Model model = new ExtendedModelMap();
		assertEquals("frase", pr.returnFrase(model));
		assertNotNull(model);
	}

	@Test
	void AEsperoRecibir5_LePaso5() {
		int num = 5;
		assertEquals("todoCorrecto", pr.esperoRecibir5(num));
	}

	@Test
	void AEsperoRecibir5_LePasoUnNumDiferenteDe5() {
		int num = 6;
		assertEquals("estoNoEraLoEsperado", pr.esperoRecibir5(num));
	}

	@Test
	void CreoUnEstudianteTest() {
		Model model = new ExtendedModelMap();
		assertEquals("resultado", pr.CreoUnEstudiante(model));

		assertNotNull(model);
		assertNotNull(model.getAttribute("ElEstudiante"));

		assertTrue(model.getAttribute("ElEstudiante") instanceof Student);
		assertInstanceOf(Student.class, model.getAttribute("ElEstudiante"));
	}

	@Spy
	Pruebas pruebasSobreLasQueEspiar = new Pruebas();

	@Test
	void EspioOperarTestSuma() {

		int result = pruebasSobreLasQueEspiar.operar(6, 2);
		assertEquals(8, result);
		
		verify(pruebasSobreLasQueEspiar, times(1)).sumar(6, 2);
		verify(pruebasSobreLasQueEspiar, times(0)).restar(anyInt(), anyInt());
		verify(pruebasSobreLasQueEspiar, times(3)).noHagoNada();
	}

	@Test
	void EspioOperarTestResta() {

		doReturn(60).when(pruebasSobreLasQueEspiar).restar(anyInt(), anyInt());

		int result = pruebasSobreLasQueEspiar.operar(1, 2);
		assertEquals(60, result);

		verify(pruebasSobreLasQueEspiar, never()).sumar(anyInt(), anyInt());
		verify(pruebasSobreLasQueEspiar, times(1)).restar(anyInt(), anyInt());
		verify(pruebasSobreLasQueEspiar, never()).noHagoNada();

		// doNothing().when(repository).insert(student);
	}

	@Mock
	Pruebas prmock = new Pruebas();

	@Test
	void MockSumaTest() {

		when(prmock.sumar(anyInt(), anyInt())).thenReturn(15);

		assertEquals(15, prmock.sumar(1, 1));
	}

	/*
	 * @Test void FechaTest() { String fraseEsperada = "si";
	 * assertEquals(fraseEsperada, pr.fecha()); }
	 */


	@Test
	public void testCalculoEdad_MenorDeEdad() {
		Date fechaNacimiento = new Date(2005, 0, 1); // 1 de enero de 2005
		assertEquals("La persona es menor de edad.", pr.CalculoEdad(fechaNacimiento));
	}

	@Test
	public void testCalculoEdad_MayorDeEdad_NoJubilado() {
		// Crear una fecha de nacimiento para una persona que debería ser mayor de edad
		// pero no jubilada
		Date fechaNacimiento = new Date(90, 0, 1); // 1 de enero de 1990
		// Llamar al método CalculoEdad con la fecha de nacimiento y verificar el
		// resultado
		assertEquals("La persona es mayor de edad pero no jubilada.", pr.CalculoEdad(fechaNacimiento));
	}

	@Test
	public void testCalculoEdad_MayorDeEdad_YJubilado() {
		Date fechaNacimiento = new Date(50, 0, 1); // 1 de enero de 1950
		assertEquals("La persona es mayor de edad y jubilada.", pr.CalculoEdad(fechaNacimiento));
	}

	@Test
	public void CalcularEdadTest() {
		Date Hoy = new Date();
		Date fechaNacimiento = new Date(90, 0, 1); // 1 de enero de 1990
		assertEquals(34, pr.calcularEdad(fechaNacimiento, Hoy));
	}

	/*
	 * @Test void CalculoEdadTest1() { Date fechaNacimiento = new Date(90, 0, 1);
	 * String fraseEsperada = "si"; assertEquals(fraseEsperada,
	 * pr.CalculoEdad(fechaNacimiento)); }
	 */

	/*
	 * public static void main(String[] args) { // Ejemplo de uso del método Date
	 * fechaNacimiento = new Date(90, 0, 1); // Fecha de nacimiento (año, mes, día)
	 * System.out.println(calcularEdadYJubilacion(fechaNacimiento)); }
	 */

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
