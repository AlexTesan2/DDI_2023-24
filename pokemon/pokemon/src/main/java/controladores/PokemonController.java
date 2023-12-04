package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import modelos.Pokemon;
import modelos.Region;
import repositorios.PokemonRepository;
import repositorios.RegionRepository;

@Controller
public class PokemonController {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired
	private RegionRepository regionRepository;

	@GetMapping("/formPokemon")
	public String showPokemonForm(Model model) {
		List<Region> regiones = regionRepository.findAll();
		model.addAttribute("pokemon", new Pokemon());
		model.addAttribute("regiones", regiones);
		return "formPokemon";
	}
	
	@PostMapping("/formPokemon")
	public String capturarPokemon(@ModelAttribute Pokemon pokemon) {
		pokemonRepository.save(pokemon);
		return "redirect:/formPokemon";
	}
	
	
	@GetMapping("/listaPokemon")
    public String listaPokemon(Model model) {
        List<Pokemon> pokemonList = pokemonRepository.findAll();
        model.addAttribute("pokemonList", pokemonList);
        return "listaPokemon";
    }
	
	
}