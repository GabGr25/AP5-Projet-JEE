package lab07.web.gateway;

import lab07.web.data.Grade;
import lab07.web.data.Student;
import lab07.web.data.Subject;
import lab07.web.data.Type;
import lab07.web.dto.GradeDTO;
import lab07.web.dto.StudentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class StudentGateway {

    public static final String URI = "/students/";

    private final RestClient restClient;

    public StudentGateway(RestClient restClient) {
        this.restClient = restClient;
    }


    public List<Student> findAll() {
        List<StudentDTO> body = restClient.get()
                .uri(URI)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        return body
                .stream()
                .map(this::fromDTO)
                .collect(Collectors.toList());
    }

    public Student findById(long studentId) {
        return fromDTO(restClient.get()
                .uri(URI + studentId)
                .retrieve()
                .body(StudentDTO.class));
    }

    private Student fromDTO(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstname(studentDTO.getFirstname());
        student.setLastname(studentDTO.getLastname());
        student.setEmail(studentDTO.getEmail());
        student.setSubjects(new ArrayList<>());

        Map<Subject, List<Grade>> gradesBySubject = new HashMap<>();
        for(GradeDTO gradeDTO: studentDTO.getGrades()){
            Subject subject = new Subject();
            subject.setId(gradeDTO.getSubject().getId());
            subject.setName(gradeDTO.getSubject().getName());
            subject.setWeight(gradeDTO.getSubject().getWeight());
            gradesBySubject.putIfAbsent(subject, new ArrayList<>());

            Type type = new Type();
            type.setId(gradeDTO.getType().getId());
            type.setName(gradeDTO.getType().getName());
            type.setWeight(gradeDTO.getType().getWeight());

            Grade grade = new Grade();
            grade.setId(gradeDTO.getId());
            grade.setGrade(gradeDTO.getGrade());
            grade.setDate(gradeDTO.getDate());
            grade.setType(type);
            gradesBySubject.get(subject).add(grade);
        }

        for(Map.Entry<Subject, List<Grade>> entry: gradesBySubject.entrySet()){
            Subject subject = entry.getKey();
            subject.setGrades(entry.getValue());
            student.getSubjects().add(subject);
        }

        return student;

    }
}
