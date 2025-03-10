package junia.projetJEE.web.controller;

import junia.projetJEE.core.service.ClasseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classes")
public class ClasseController {

    private ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }
    
}
