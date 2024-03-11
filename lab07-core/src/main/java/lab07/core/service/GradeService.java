package lab07.core.service;

import jakarta.transaction.Transactional;
import lab07.core.entity.Grade;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GradeService {

    //TODO make it compile by creating the necessary classes (beans) and methods

    private final GradeDAO gradeDAO;
    private final TypeService typeService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public GradeService(GradeDAO gradeDAO, TypeService typeService, StudentService studentService, SubjectService subjectService) {
        this.gradeDAO = gradeDAO;
        this.typeService = typeService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    public void deleteAll() {
        gradeDAO.deleteAll();
    }

    public void deleteGrade(long gradeId) {
        gradeDAO.deleteById(gradeId);
    }

    public Grade findById(long gradeId) {
        return gradeDAO.findById(gradeId).orElse(null);
    }

    public void update(Grade grade) {
        Grade gradeToUpdate = findById(grade.getId());
        gradeToUpdate.setGrade(grade.getGrade());
        gradeToUpdate.setDate(grade.getDate());
        gradeToUpdate.setType(typeService.findById(grade.getType().getId()));
        gradeDAO.save(gradeToUpdate);
    }

    public void save(Grade grade, long studentId, long subjectId) {
        grade.setStudent(studentService.findById(studentId));
        grade.setSubject(subjectService.findById(subjectId));
        grade.setType(typeService.findById(grade.getType().getId()));
        gradeDAO.save(grade);
    }
}
