package lab07.web.controller;

import lab07.web.data.Student;
import lab07.web.data.Subject;
import lab07.web.gateway.StudentGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentGateway studentGateway;

    public StudentController(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @GetMapping({"/", ""})
    public String listStudents(Model model) {
        List<Student> students = studentGateway.findAll();
        for(Student student:students){
            Collections.sort(student.getSubjects());
        }
        model.addAttribute("students", students);
        return "students/home";
    }


    @GetMapping({"/{studentId:\\d+}"})
    public String getStudentDetails(Model model, @PathVariable("studentId")long studentId) {
        Student student = studentGateway.findById(studentId);
        Collections.sort(student.getSubjects());
        for(Subject subject:student.getSubjects()){
            Collections.sort(subject.getGrades());
        }
        model.addAttribute("student", student);
        return "students/details";
    }
}
