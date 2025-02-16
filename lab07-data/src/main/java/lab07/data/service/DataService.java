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
        students.add(new Student("Myra","Hager","MyraPHager@rhyta.com"));
        students.add(new Student("Jeffrey","Andrade","JeffreyDAndrade@teleworm.us"));
        students.add(new Student("Larry","Hamilton","LarrySHamilton@dayrep.com"));
        students.add(new Student("William","McManus","WilliamRMcManus@fleckens.hu"));
        students.add(new Student("John","Bailey","JohnHBailey@cuvox.de"));
        students.add(new Student("Michael","Wilbur","MichaelDWilbur@superrito.com"));
        students.add(new Student("Charlene","Scales","CharleneMScales@gustr.com"));
        students.add(new Student("Bonnie","Bond","BonnieGBond@gustr.com"));
        students.add(new Student("Kellie","Burruss","KellieBBurruss@armyspy.com"));
        students.add(new Student("Jesse","Davenport","JesseDDavenport@fleckens.hu"));
        students.add(new Student("Elizabeth","Isaac","ElizabethJIsaac@einrot.com"));
        students.add(new Student("Joshua","George","JoshuaBGeorge@dayrep.com"));
        students.add(new Student("Tony","Chen","TonyDChen@cuvox.de"));
        students.add(new Student("Miranda","Coleman","MirandaAColeman@teleworm.us"));
        students.add(new Student("Carlos","Pennell","CarlosKPennell@dayrep.com"));
        students.add(new Student("Jennie","Mobley","JennieAMobley@armyspy.com"));
        students.add(new Student("Julia","Lawrence","JuliaJLawrence@einrot.com"));
        students.add(new Student("Laura","Robinson","LauraMRobinson@superrito.com"));
        students.add(new Student("Jennifer","Burkhardt","JenniferKBurkhardt@gustr.com"));
        students.add(new Student("James","Williams","JamesCWilliams@fleckens.hu"));
        students.add(new Student("Carrie","Day","CarrieKDay@jourrapide.com"));
        students.add(new Student("Alfred","Bohl","AlfredKBohl@teleworm.us"));
        students.add(new Student("Bruce","Person","BruceJPerson@gustr.com"));
        students.add(new Student("Lyn","Faulk","LynSFaulk@einrot.com"));
        students.add(new Student("Andrea","Saldana","AndreaWSaldana@teleworm.us"));
        students.add(new Student("Roland","Johnson","RolandJJohnson@jourrapide.com"));
        students.add(new Student("John","Pellegrino","JohnAPellegrino@einrot.com"));
        students.add(new Student("William","Hawkins","WilliamZHawkins@armyspy.com"));
        students.add(new Student("Marketta","Matheson","MarkettaWMatheson@superrito.com"));
        students.add(new Student("Joanne","Defelice","JoanneRDefelice@fleckens.hu"));


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
