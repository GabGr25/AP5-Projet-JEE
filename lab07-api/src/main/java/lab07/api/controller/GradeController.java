package lab07.api.controller;

import lab07.core.service.GradeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;

    }

    //TODO expose the correct APIs


}
