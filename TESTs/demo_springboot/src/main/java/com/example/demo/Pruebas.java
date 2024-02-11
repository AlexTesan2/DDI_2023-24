package com.example.demo;

import org.springframework.ui.Model;

import com.example.demo.model.Student;


public class Pruebas {

	public int sumar(int x, int y) {
		return (x + y);
	}

	public int restar(int x, int y) {
		return (x - y);
	}

	public void noHagoNada() {
		// Cuantas veces me lamaras?
	}

	public int operar(int x, int y) {
		if (x > y) {
			noHagoNada();
			noHagoNada();
			noHagoNada();
			return (sumar(x, y));
		} else
			return (restar(x, y));
	}

	public double dividir(double dividendo, double divisor) {
		if (divisor == 0)
			return ('∞');
		else
			return (dividendo / divisor);
	}

	public double dividirASecas(double dividendo, double divisor) {
		return (dividendo / divisor);
	}

	public String returnFrase(Model model) {
		return "frase";
	}


	public String esperoRecibir5(int cinco) {
		if (cinco == 5)
			return "todoCorrecto";
		else
			return "estoNoEraLoEsperado";
	}


	public String CreoUnEstudiante(Model model) {
		model.addAttribute("ElEstudiante", new Student());
		return "resultado";
	}

	public void metodoQueLanzaExcepcion(int num) {
		String cadena;
		if (num == 6)
			cadena = "llena";
		else
			cadena = null;
		cadena.length();
	}

	public void metodoQueLanzaExcepcionCreadaPorMi() throws MiExcepcion {
		throw new MiExcepcion("Este es un mensaje de excepción personalizado");
	}

	public class MiExcepcion extends Exception {
		public MiExcepcion(String message) {
			super(message);
		}
	}
}
