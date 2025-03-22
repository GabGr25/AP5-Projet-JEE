package junia.projetJEE.web.controller;

import junia.projetJEE.core.entity.Carte;
import junia.projetJEE.core.service.IdGeneratorService;
import junia.projetJEE.core.service.CarteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cartes")
public class CarteController {

    private final CarteService carteService;
    private final IdGeneratorService idGeneratorService;

    public CarteController(CarteService carteService, IdGeneratorService idGeneratorService) {
        this.carteService = carteService;
        this.idGeneratorService = idGeneratorService;
    }

    @GetMapping({"/", ""})
    public String getCarte(ModelMap modelMap) {
        long carteId = idGeneratorService.generateId(carteService);
        Carte carte = carteService.findOne(carteId);
        modelMap.addAttribute("carte", carte);
        return "Carte";
    }

    @GetMapping("/noms")
    @ResponseBody
    public List<String> getCarteNoms() {
        return carteService.getAllCarteNoms(); // Appelle la nouvelle méthode du service
    }


    @PostMapping("/validator")
    public String validateCarte(@RequestParam("Name") String name, ModelMap modelMap) {
        long carteId = idGeneratorService.generateId(carteService);
        Carte carte = carteService.findOne(carteId);
        modelMap.addAttribute("carte", carte);
        if (carte.getNom().equalsIgnoreCase(name)) {
            return "redirect:/cartes/win";
        }

        modelMap.addAttribute("errorMessage", "Ce n'est pas le bon Donjon ... Essayer encore !");
        return "Carte";
    }

    @GetMapping("/win")
    public String win(ModelMap modelMap) {
        long carteId = idGeneratorService.generateId(carteService);
        Carte carte = carteService.findOne(carteId);
        modelMap.addAttribute("carte", carte);
        return "CarteWin";
    }
}