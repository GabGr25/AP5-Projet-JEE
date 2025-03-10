package junia.projetJEE.web.controller;

import junia.projetJEE.core.service.CarteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cartes")
public class CarteController {

    private CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }
}
