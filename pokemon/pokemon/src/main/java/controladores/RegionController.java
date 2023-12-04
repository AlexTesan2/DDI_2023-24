package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import modelos.Region;
import repositorios.RegionRepository;

@Controller
public class RegionController {

	@Autowired
	private RegionRepository regionRepository;

	@GetMapping("/formRegion")
	public String showRegionForm(Model model) {
		model.addAttribute("region", new Region());
		return "formRegion";
	}

	@PostMapping("/formRegion")
	public String registrarRegion(@ModelAttribute Region region) {
		regionRepository.save(region);
		return "redirect:/formRegion";
	}

	@GetMapping("/listaRegion")
	public String listaRegion(Model model) {
		List<Region> regionList = regionRepository.findAll();
		model.addAttribute("regionList", regionList);
		return "listaRegion";
	}

}
