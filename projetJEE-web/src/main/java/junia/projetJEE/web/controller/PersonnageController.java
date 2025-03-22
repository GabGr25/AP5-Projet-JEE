package junia.projetJEE.web.controller;

import junia.projetJEE.core.entity.Personnage;
import junia.projetJEE.core.service.IdGeneratorService;
import junia.projetJEE.core.service.PersonnageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {

    private final PersonnageService personnageService;
    private final IdGeneratorService idGeneratorService;

    public PersonnageController(PersonnageService personnageService, IdGeneratorService idGeneratorService) {
        this.personnageService = personnageService;
        this.idGeneratorService = idGeneratorService;
    }

    @GetMapping({"/", ""})
    public String getPersonnage(ModelMap modelMap) {
        long personnageId = idGeneratorService.generateId(personnageService);
        Personnage personnage = personnageService.findOne(personnageId);
        modelMap.addAttribute("personnage", personnage);
        return "Personnage";
    }

    @GetMapping("/noms")
    @ResponseBody
    public List<String> getCarteNoms() {
        return personnageService.getAllPersonnage(); // Appelle la nouvelle méthode du service
    }

    @PostMapping("/validator")
    public String validatePersonnage(@RequestParam("Name")String name, ModelMap modelMap) {
        long personnageId = idGeneratorService.generateId(personnageService);
        Personnage personnage = personnageService.findOne(personnageId);
        modelMap.addAttribute("personnage", personnage);
        if(personnage.getNom().equalsIgnoreCase(name)) {
            return "redirect:/personnages/win";
        }

        modelMap.addAttribute("errorMessage", "Ce n'est pas le bon nom ... Essayer encore !");
        return "Personnage";
    }

    @GetMapping("/win")
    public String win(ModelMap modelMap) {
        long personnageId = idGeneratorService.generateId(personnageService);
        Personnage personnage = personnageService.findOne(personnageId);
        modelMap.addAttribute("personnage", personnage);
        return "PersonnageWin";
    }
}
