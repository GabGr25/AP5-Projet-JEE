package lab07.data.service;

import jakarta.annotation.PostConstruct;
import lab07.core.entity.Grade;
import lab07.core.entity.Student;
import lab07.core.entity.Subject;
import lab07.core.entity.Type;
import lab07.core.service.GradeService;
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


    private List<Type>  registerTypes() {
       List<Type> types = new ArrayList<>();
        types.add( createType("Homework", 1));
        types.add( createType("Exam", 3));
        types.add( createType("Project", 2));
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
        students.add(new Student("Ahmed", "ABOELNAGA", "ahmed.aboelnaga@student.junia.com"));
        students.add(new Student("Isabella", "BACALAO", "isabella.bacalao@student.junia.com"));
        students.add(new Student("Ronan", "BALUSSON", "ronan.balusson@student.junia.com"));
        students.add(new Student("Marc", "BAYART", "marc.bayart@student.junia.com"));
        students.add(new Student("Ahmed", "BEN HADDOU", "ahmed.ben-haddou@student.junia.com"));
        students.add(new Student("Yanis", "BENZIZOUN", "yanis.benzizoun@student.junia.com"));
        students.add(new Student("Maël", "BIZOT", "mael.bizot@student.junia.com"));
        students.add(new Student("Habib", "BOUZGUENDA", "habib.bouzguenda@student.junia.com"));
        students.add(new Student("Gabriel", "BURGHGRAVE", "gabriel.burghgrave@student.junia.com"));
        students.add(new Student("Charles", "CHAUDRON", "charles.chaudron@student.junia.com"));
        students.add(new Student("Loïc", "CLEDELIN", "loic.cledelin@student.junia.com"));
        students.add(new Student("Léonard", "CORRE", "leonard.corre@student.junia.com"));
        students.add(new Student("Ulysse", "DAHIEZ", "ulysse.dahiez@student.junia.com"));
        students.add(new Student("Axel", "DERLY", "axel.derly@student.junia.com"));
        students.add(new Student("Marine", "DUTAILLY", "marine.dutailly@student.junia.com"));
        students.add(new Student("Hugo", "DUTOIT", "hugo.dutoit@student.junia.com"));
        students.add(new Student("César", "DUVAL", "cesar.duval@student.junia.com"));
        students.add(new Student("Etienne", "EL GUEDER", "etienne.el-gueder@student.junia.com"));
        students.add(new Student("Benjamin", "HAUTIER", "benjamin.hautier@student.junia.com"));
        students.add(new Student("Baptiste", "HERBECQ", "baptiste.herbecq@student.junia.com"));
        students.add(new Student("Marty", "HUGHES", "marty.hughes@student.junia.com"));
        students.add(new Student("Bilal", "KADRI", "bilal.kadri@student.junia.com"));
        students.add(new Student("Julien", "LECAT", "julien.lecat@student.junia.com"));
        students.add(new Student("Matthieu", "LOUCHIE", "matthieu.louchie@student.junia.com"));
        students.add(new Student("Michelle", "MARTIN", "michelle.martin@student.junia.com"));
        students.add(new Student("Allan", "MATANGA LOVET", "allan.matanga-lovet@student.junia.com"));
        students.add(new Student("Martin", "MILLE", "martin.mille@student.junia.com"));
        students.add(new Student("Adam", "OUALI", "adam.ouali@student.junia.com"));
        students.add(new Student("Mathis", "VANDEVENNE", "mathis.vandevenne@student.junia.com"));
        students.add(new Student("Elise", "VERHOEST", "elise.verhoest@student.junia.com"));
        students.add(new Student("Léonie", "WOLFCARIUS", "leonie.wolfcarius@student.junia.com"));
        students.add(new Student("Clément", "ZAJAC", "clement.zajac@student.junia.com"));

        for(Student student:students){
            List<Grade> grades = new ArrayList<>();
            for(Subject subject:subjects.values()){
                for (int i = 0; i < 5 + random.nextInt(6); i++) {
                    LocalDate localDate = LocalDate.now().minusDays(random.nextInt(200));
                    Type type = types.get(random.nextInt(3));
                    grades.add(new Grade(student,subject, localDate, type,10 + random.nextInt(11)));
                }
            }
            student.setGrades(grades);
            studentService.save(student);
        }


    }
}
