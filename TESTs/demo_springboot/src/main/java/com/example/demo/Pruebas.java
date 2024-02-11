package com.example.demo;

import java.util.Date;

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


	public String fecha() {
		Date fechaActual = new Date();
		String frase = ("La fecha y hora actual es: " + fechaActual);
		return frase;
	}



	public String CalculoEdad(Date fechaNacimiento) {
        Date fechaActual = new Date();
        int edad = calcularEdad(fechaNacimiento, fechaActual);

        if (edad >= 18) {
            if (edad >= 65) {
                return "La persona es mayor de edad y jubilada.";
            } else {
                return "La persona es mayor de edad pero no jubilada.";
            }
        } else {
            return "La persona es menor de edad.";
        }
    }

    public int calcularEdad(Date fechaNacimiento, Date fechaActual) {
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaActual.getMonth() < fechaNacimiento.getMonth()
                || (fechaActual.getMonth() == fechaNacimiento.getMonth() && fechaActual.getDate() < fechaNacimiento.getDate())) {
            edad--;
        }
        return edad;
    }
}


