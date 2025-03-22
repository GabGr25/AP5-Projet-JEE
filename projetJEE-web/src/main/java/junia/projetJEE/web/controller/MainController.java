package junia.projetJEE.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMenu(ModelMap modelMap) {
        return "Menu"; // Cette ligne retourne le template Menu.html
    }
}