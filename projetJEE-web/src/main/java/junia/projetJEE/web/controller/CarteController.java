package junia.projetJEE.web.controller;

import jakarta.servlet.http.HttpSession;
import junia.projetJEE.core.entity.Carte;
import junia.projetJEE.core.service.IdGeneratorService;
import junia.projetJEE.core.service.CarteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cartes")
public class CarteController {

    private final CarteService carteService;
    private final IdGeneratorService idGeneratorService;
    private final static Logger LOGGER = LoggerFactory.getLogger(CarteController.class);


    public CarteController(CarteService carteService, IdGeneratorService idGeneratorService) {
        this.carteService = carteService;
        this.idGeneratorService = idGeneratorService;
    }

    private Carte getOrGenerateCarte(HttpSession session) {
        Carte carte = (Carte) session.getAttribute("carteDuJour");

        if (carte == null) {
            long carteId = idGeneratorService.generateId(carteService);
            LOGGER.debug("Carte id : {}", carteId);
            carte = carteService.findOne(carteId);
            session.setAttribute("carteDuJour", carte);
            LOGGER.debug("Carte added to session : {}", session.getAttribute("carteDuJour"));
        }

        return carte;
    }

    private List<String> getOrCreateAllNamesCartes(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> nomsCartes = (List<String>) session.getAttribute("allCartesNames");

        if (nomsCartes == null) {
            nomsCartes = carteService.getAllCarteNoms();
            session.setAttribute("allCartesNames", nomsCartes);
            LOGGER.info("Cartes added to session Attribute");
        }

        return nomsCartes;
    }

    @GetMapping({"/", ""})
    public String getCarte(ModelMap modelMap, HttpSession session) {
        Carte carte = getOrGenerateCarte(session);
        List<String> cartes = getOrCreateAllNamesCartes(session);

        modelMap.addAttribute("carte", carte);
        LOGGER.debug("carte in modelMap : {}", carte);
        modelMap.addAttribute("nomsCartes", cartes);
        LOGGER.debug("cartes in modelMap : {}", cartes);

        return "Carte";
    }

    @PostMapping("/validator")
    public String validateCarte(@RequestParam("nomCarte") String name, ModelMap modelMap, HttpSession session) {
        Carte carte = getOrGenerateCarte(session);
        List<String> nomsCartes = getOrCreateAllNamesCartes(session);

        modelMap.addAttribute("carte", carte);
        modelMap.addAttribute("nomsCartes", nomsCartes);

        if (carte.getNom().equalsIgnoreCase(name)) {
            session.setAttribute("CarteWin", true);
            LOGGER.info("Carte trouvé");
            LOGGER.debug("CarteWin set to  {}", session.getAttribute("CarteWin"));
            return "redirect:/cartes/win";
        }

        LOGGER.info("Carte pas trouvé");
        modelMap.addAttribute("errorMessage", "Ce n'est pas le bon Donjon ... Essayer encore !");
        LOGGER.info("Erreur ajouté au model map");
        return "Carte";
    }

    @GetMapping("/win")
    public String win(ModelMap modelMap, @SessionAttribute(value = "CarteWin", required = false) Boolean gagne, HttpSession session) {
        if (Boolean.TRUE.equals(gagne)) {
            Carte carte = getOrGenerateCarte(session);
            modelMap.addAttribute("carte", carte);
            LOGGER.info("Bonne réponse, l'utilisateur a gagné");
            return "CarteWin";
        }
        return "redirect:/cartes";
    }
}
