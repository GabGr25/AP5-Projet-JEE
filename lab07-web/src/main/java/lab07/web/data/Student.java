package lab07.web.data;

import java.util.List;

public class Student {

    private long id;

    private String firstname;

    private String lastname;


    private String email;

    private List<Subject> subjects;

    public Student() {
    }

    public Student(long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public int getItemNumbers(){
        return subjects.stream().mapToInt(s->s.getGrades().size()).sum()+subjects.size();
    }

    public double getAverage() {
        double sumOfSubjects = 0;
        double sumOfWeights = 0;
        for (Subject subject : subjects) {
            sumOfSubjects += subject.getWeight() * subject.getAverage();
            sumOfWeights += subject.getWeight();
        }
        return sumOfSubjects / sumOfWeights;
    }
}
