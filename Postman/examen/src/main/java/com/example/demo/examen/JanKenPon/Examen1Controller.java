package com.example.demo.examen.JanKenPon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/jankenpon/")
public class Examen1Controller {
	int puntosJugador1 = 0;
    int puntosJugador2 = 0;
    List<Resultado> resultados = new ArrayList<>();

    @PostMapping
    @RequestMapping(value = "/play")
    public ResponseEntity<ResultadoJuego> play(@RequestParam String jugador1, @RequestParam String jugador2) {
        String message = "";
        String winner = "";

        if (jugador1.equals(jugador2)) {
            message = "Empate";
        } else if ((jugador1.equals("piedra") && jugador2.equals("tijeras"))
                || (jugador1.equals("papel") && jugador2.equals("piedra"))
                || (jugador1.equals("tijeras") && jugador2.equals("papel"))) {
            message = "jugador1";
            puntosJugador1++;
            winner = "jugador1"; // Jugador 1 gana
            resultados.add(new Resultado("jugador1", puntosJugador1));
        } else if ((jugador2.equals("piedra") && jugador1.equals("tijeras"))
                || (jugador2.equals("papel") && jugador1.equals("piedra"))
                || (jugador2.equals("tijeras") && jugador1.equals("papel"))) {
            message = "jugador2";
            puntosJugador2++;
            winner = "jugador2"; // Jugador 2 gana
            resultados.add(new Resultado("jugador2", puntosJugador2));
        } else {
            message = "Se ha producido un error, asegurate de que los datos sean (piedra,papel,tijeras)";
            puntosJugador2++;
        }

        ResultadoJuego resultadoJuego = new ResultadoJuego(message, winner);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultadoJuego);
    }

	@GetMapping
	@RequestMapping(value = "/results/{Jugador}")
	public ResponseEntity<List<Resultado>> play(@PathVariable String Jugador) {
		List<Resultado> resultados = new ArrayList<>();

		int ronda = 1;

		if (Jugador.equals("j1")) {
			for (Resultado resultado : this.resultados) {
				resultado.setRonda(ronda);
				resultado.setPlayer("j1"); // Establece el jugador como "j1"
				resultados.add(resultado);
				ronda++;
			}
		} else if (Jugador.equals("j2")) {
			for (Resultado resultado : this.resultados) {
				resultado.setRonda(ronda);
				resultado.setPlayer("j2"); // Establece el jugador como "j2"
				resultados.add(resultado);
				ronda++;
			}
		} else {
			resultados.add(new Resultado("Se ha producido un error, asegurate de que los datos sean (j1,j2)", 0));
			return ResponseEntity.badRequest().body(resultados);
		}

		return ResponseEntity.ok(resultados);
    }

    public static class ResultadoJuego {
        private String message;
        private String winner;

        public ResultadoJuego(String message, String winner) {
            this.message = message;
            this.winner = winner;
        }

        public String getMessage() {
            return message;
        }

        public String getWinner() {
            return winner;
        }
    }

	public class Resultado {
		private String winner;
		private int puntos;
		private int ronda;
		private String player;

		public Resultado(String winner, int puntos) {
			this.winner = winner;
			this.puntos = puntos;
			this.ronda = 0;
			this.player = "";
		}

		public String getPlayer() {
			return player;
		}

		public void setPlayer(String player) {
			this.player = player;
		}

		public String getWinner() {
			return winner;
		}

		public void setWinner(String winner) {
			this.winner = winner;
		}

		public int getPuntos() {
			return puntos;
		}

		public void setPuntos(int puntos) {
			this.puntos = puntos;
		}

		public int getRonda() {
			return ronda;
		}

		public void setRonda(int ronda) {
			this.ronda = ronda;
		}
	}
}
// noseque de start doots bola de 4 esttrellas jdonData.startDoots
// th de lenth en los del dragon