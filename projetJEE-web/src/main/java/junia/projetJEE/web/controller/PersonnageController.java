package junia.projetJEE.web.controller;

import jakarta.servlet.http.HttpSession;
import junia.projetJEE.core.entity.Personnage;
import junia.projetJEE.core.service.IdGeneratorService;
import junia.projetJEE.core.service.PersonnageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personnages")
public class PersonnageController {

    private final PersonnageService personnageService;
    private final IdGeneratorService idGeneratorService;
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonnageController.class);

    public PersonnageController(PersonnageService personnageService, IdGeneratorService idGeneratorService) {
        this.personnageService = personnageService;
        this.idGeneratorService = idGeneratorService;
    }

    private Personnage getOrGeneratePersonnage(HttpSession session) {
        Personnage personnage = (Personnage) session.getAttribute("personnageDuJour");

        if (personnage == null) {
            long personnageId = idGeneratorService.generateId(personnageService);
            LOGGER.debug("Personnage id : {}", personnageId);
            personnage = personnageService.findOne(personnageId);
            session.setAttribute("personnageDuJour", personnage);
            LOGGER.debug("Personnage added to session : {}", session.getAttribute("personnageDuJour"));
        }

        return personnage;
    }

    private List<String> getOrCreateAllNamesPersonnages(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> nomsPersonnages = (List<String>) session.getAttribute("allPersonnageNames");

        if (nomsPersonnages == null) {
            nomsPersonnages = personnageService.getAllPersonnageNoms();
            session.setAttribute("allPersonnageNames", nomsPersonnages);
            LOGGER.info("Personnages added to session Attribute");
        }

        return nomsPersonnages;
    }

    @GetMapping({"/", ""})
    public String getPersonnage(ModelMap modelMap, HttpSession session) {
        Personnage personnage = getOrGeneratePersonnage(session);
        List<String> nomsPersonnages = getOrCreateAllNamesPersonnages(session);

        modelMap.addAttribute("personnage", personnage);
        LOGGER.debug("personnage in modelMap : {}", personnage);
        modelMap.addAttribute("nomsPersonnages", nomsPersonnages);
        LOGGER.debug("personnages in modelMap : {}", nomsPersonnages);

        return "Personnage";
    }

    @PostMapping("/validator")
    public String validatePersonnage(@RequestParam("nomPersonnage") String name, ModelMap modelMap, HttpSession session) {
        Personnage personnage = getOrGeneratePersonnage(session);
        List<String> nomsPersonnages = getOrCreateAllNamesPersonnages(session);

        modelMap.addAttribute("personnage", personnage);
        modelMap.addAttribute("nomsPersonnages", nomsPersonnages);

        if (personnage.getNom().equalsIgnoreCase(name)) {
            session.setAttribute("PersoWin", true);
            LOGGER.info("Personnage trouvé");
            LOGGER.debug("PersoWin set to  {}", session.getAttribute("PersoWin"));
            return "redirect:/personnages/win";
        }

        LOGGER.info("Personnage pas trouvé");
        modelMap.addAttribute("errorMessage", "Ce n'est pas le bon nom ... Essaye encore !");
        LOGGER.info("Erreur ajouté au model map");
        return "Personnage";
    }

    @GetMapping("/win")
    public String win(ModelMap modelMap, @SessionAttribute(value = "PersoWin", required = false) Boolean gagne, HttpSession session) {
        if (Boolean.TRUE.equals(gagne)) {
            Personnage personnage = getOrGeneratePersonnage(session);
            modelMap.addAttribute("personnage", personnage);
            LOGGER.info("Bonne réponse, l'utilisateur a gagné");
            return "PersonnageWin";
        }
        return "redirect:/personnages";
    }

}
