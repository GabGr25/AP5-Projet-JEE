package junia.projetJEE.web.controller;

import junia.projetJEE.core.entity.Personnage;
import junia.projetJEE.core.service.PersonnageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {

    private PersonnageService personnageService;

    public PersonnageController(PersonnageService personnageService) {
        this.personnageService = personnageService;
    }

    @GetMapping("/today")
    public Personnage personnageOfTheDay(){
        long sizePersonnages = personnageService.countAll();
        int jourDuMois = LocalDate.now().getDayOfMonth();
        long personnageId = (jourDuMois <= sizePersonnages) ? jourDuMois : (jourDuMois % sizePersonnages) + 1;
        return personnageService.findOne(personnageId);
    }

}
