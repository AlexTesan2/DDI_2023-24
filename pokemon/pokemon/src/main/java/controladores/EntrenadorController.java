package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import modelos.Entrenador;
import repositorios.EntrenadorRepository;

@Controller
public class EntrenadorController {

	@Autowired
	private EntrenadorRepository entrenadorRepository;

	@GetMapping("/formEntrenador")
	public String showEntrenadorForm(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		return "formEntrenador";
	}

	@PostMapping("/formEntrenador")
	public String registrarEntrenador(@ModelAttribute Entrenador entrenador) {
		entrenadorRepository.save(entrenador);
		return "redirect:/formEntrenador";
	}

	@GetMapping("/listaEntrenadores")
	public String listaEntrenadores(Model model) {
		List<Entrenador> entrenadores = entrenadorRepository.findAll();
		model.addAttribute("entrenadores", entrenadores);
		return "listaEntrenadores";
	}
}
