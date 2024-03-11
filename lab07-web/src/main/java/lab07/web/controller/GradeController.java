package lab07.web.controller;

import lab07.web.data.Grade;
import lab07.web.data.Subject;
import lab07.web.gateway.GradeGateway;
import lab07.web.gateway.StudentGateway;
import lab07.web.gateway.SubjectGateway;
import lab07.web.gateway.TypeGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grades")
public class GradeController {

    private final GradeGateway gradeGateway;

    private final StudentGateway studentGateway;

    private final SubjectGateway subjectGateway;

    private final TypeGateway typesGateway;

    public GradeController(GradeGateway gradeGateway, StudentGateway studentGateway, SubjectGateway subjectGateway, TypeGateway typesGateway) {
        this.gradeGateway = gradeGateway;
        this.studentGateway = studentGateway;
        this.subjectGateway = subjectGateway;
        this.typesGateway = typesGateway;
    }

    @GetMapping("/edit/{gradeId:\\d+}")
    public String showEditForm(Model model, @PathVariable("gradeId") long gradeId, @RequestParam("studentId") long studentId) {
        Grade grade = gradeGateway.findById(gradeId);
        model.addAttribute("grade", grade);
        model.addAttribute("student", studentGateway.findById(studentId));
        model.addAttribute("subject", grade.getSubject());
        model.addAttribute("types", typesGateway.findAll());
        model.addAttribute("action", "edit");
        return "grades/gradeform";
    }

    @PostMapping("/edit/{gradeId:\\d+}")
    public String editGrade(@ModelAttribute("grade") Grade grade, @RequestParam("studentId") long studentId, @RequestParam("subjectId") long subjectId) {
        gradeGateway.updateGrade(grade);
        return "redirect:/students/" + studentId;
    }

    @GetMapping("/add/")
    public String showAddForm(Model model, @RequestParam("studentId") long studentId, @RequestParam("subjectId") long subjectId) {
        Grade grade = new Grade();
        Subject subject = subjectGateway.findById(subjectId);
        grade.setSubject(subject);

        model.addAttribute("grade", grade);
        model.addAttribute("student", studentGateway.findById(studentId));
        model.addAttribute("subject", subject);
        model.addAttribute("types", typesGateway.findAll());
        model.addAttribute("action", "add");
        return "grades/gradeform";
    }


    @PostMapping("/add/0")
    public String addGrade(@ModelAttribute("grade") Grade grade, @RequestParam("studentId") long studentId, @RequestParam("subjectId") long subjectId) {
        gradeGateway.addGrade(grade, studentId, subjectId);
        return "redirect:/students/" + studentId;
    }


    @GetMapping("/delete/{gradeId:\\d+}")
    public String deleteGrade(@PathVariable("gradeId") long gradeId, @RequestParam("studentId") long studentId) {
        gradeGateway.deleteGrade(gradeId);
        return "redirect:/students/" + studentId;
    }
}
