package lab07.api.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;

    }

    //TODO expose the correct APIs


}
