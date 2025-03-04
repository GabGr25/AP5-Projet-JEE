package junia.projetJEE.web.controller;

import junia.projetJEE.core.entity.Saga;
import junia.projetJEE.core.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("sagas")
public class SagasController {

    private SagaService sagaService;

    @Autowired
    public SagasController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @GetMapping("/list")
    public String getListOfSagas(ModelMap modelMap) {
        List<Saga> sagas = sagaService.findAllWithPhasesAndMovies();
        modelMap.addAttribute("sagas", sagas);
        return "SagasList";
    }
}
