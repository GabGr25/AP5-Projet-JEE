package lab07.data.service;

import jakarta.annotation.PostConstruct;
import lab07.core.entity.Grade;
import lab07.core.entity.Student;
import lab07.core.entity.Subject;
import lab07.core.entity.Type;
import lab07.core.service.GradeService;
import lab07.core.service.StudentService;
import lab07.core.service.SubjectService;
import lab07.core.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class DataService {

    private final GradeService gradeService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final TypeService typeService;

    public DataService(GradeService gradeService, StudentService studentService, SubjectService subjectService, TypeService typeService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.typeService = typeService;
    }


    @PostConstruct
    public void initData() throws Exception {
        cleanDB();
        final List<Type> types = registerTypes();
        final Map<String, Subject> subjects = registerSubjects();
        registerStudents(subjects, types);
    }

    private void cleanDB() {
        gradeService.deleteAll();
        studentService.deleteAll();
        subjectService.deleteAll();
        typeService.deleteAll();
    }


    private List<Type> registerTypes() {
        List<Type> types = new ArrayList<>();
        types.add(createType("Homework", 1));
        types.add(createType("Exam", 3));
        types.add(createType("Project", 2));
        return types;
    }

    private Type createType(String typeName, int weight) {
        System.out.println("Registring " + typeName);
        Type type = new Type();
        type.setWeight(weight);
        type.setName(typeName);
        typeService.save(type);
        return type;
    }


    private Map<String, Subject> registerSubjects() {
        Map<String, Subject> subjects = new HashMap<>();
        subjects.put("algebra", createSubject("Algebra", 3));
        subjects.put("biology", createSubject("Biology", 2));
        subjects.put("chemistry", createSubject("Chemistry", 1));
        subjects.put("geometry", createSubject("Geometry", 4));
        subjects.put("mathematics", createSubject("Mathematics", 5));
        subjects.put("music", createSubject("Music", 1));
        subjects.put("physics", createSubject("Physics", 4));
        return subjects;
    }


    private Subject createSubject(String subjectName, int weight) {
        System.out.println("Registring " + subjectName);
        Subject subject = new Subject();
        subject.setName(subjectName);
        subject.setWeight(weight);
        subjectService.save(subject);
        return subject;
    }


    private void registerStudents(Map<String, Subject> subjects, List<Type> types) {
        Random random = new Random();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Martin", "BASQUE FRIBAULT", "martin.basque-fribault@student.junia.com"));
        students.add(new Student("Clovis", "CHATRY", "clovis.chatry@student.junia.com"));
        students.add(new Student("Mohamed", "CHIKH", "mohamed.chikh@student.junia.com"));
        students.add(new Student("Hugo", "COISNE", "hugo.coisne@student.junia.com"));
        students.add(new Student("Alfred", "COUVREUR", "alfred.couvreur@student.junia.com"));
        students.add(new Student("Clément", "DE TEMMERMAN", "clement.de-temmerman@student.junia.com"));
        students.add(new Student("Tristan", "DESROUSSEAUX", "tristan.desrousseaux@student.junia.com"));
        students.add(new Student("Raphaël", "DOUCET", "raphael.doucet@student.junia.com"));
        students.add(new Student("Eugene", "DUSAUSOY", "eugene.dusausoy@student.junia.com"));
        students.add(new Student("Hassan", "GHANDOUR", "hassan.ghandour@student.junia.com"));
        students.add(new Student("Adrien", "GUILLOT", "adrien.guillot@student.junia.com"));
        students.add(new Student("Gauthier", "HORVILLE", "gauthier.horville@student.junia.com"));
        students.add(new Student("Timothe", "LAINE", "timothe.laine@student.junia.com"));
        students.add(new Student("Chloe", "LELONG", "chloe.lelong@student.junia.com"));
        students.add(new Student("Edouard", "LUYSSAERT", "edouard.luyssaert@student.junia.com"));
        students.add(new Student("Pierre", "Olivier	MALPHETTES", "pierre-olivier.malphettes@student.junia.com"));
        students.add(new Student("Eliseph", "MOUSSAVOU MOUSSAVOU", "eliseph.moussavou-moussavou@student.junia.com"));
        students.add(new Student("Etienne", "OSWALD", "etienne.oswald@student.junia.com"));
        students.add(new Student("Charles", "PRETET", "charles.pretet@student.junia.com"));
        students.add(new Student("Salomé", "ROBIN", "salome.robin@student.junia.com"));
        students.add(new Student("Hugo", "SANSON", "hugo.sanson@student.junia.com"));
        students.add(new Student("Clément", "TOULORGE", "clement.toulorge@student.junia.com"));
        students.add(new Student("Willy", "ZHENG", "willy.zheng@student.junia.com"));


        for (Student student : students) {
            List<Grade> grades = new ArrayList<>();
            for (Subject subject : subjects.values()) {
                for (int i = 0; i < 5 + random.nextInt(6); i++) {
                    LocalDate localDate = LocalDate.now().minusDays(random.nextInt(200));
                    Type type = types.get(random.nextInt(3));
                    grades.add(new Grade(student, subject, localDate, type, 10 + random.nextInt(11)));
                }
            }
            student.setGrades(grades);
            studentService.save(student);
        }


    }
}
