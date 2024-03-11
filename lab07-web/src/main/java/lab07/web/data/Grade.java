package lab07.web.data;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Grade implements Comparable<Grade> {

    private long id;

    private int grade;

    private Type type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Subject subject;

    public Grade() {
    }

    public Grade(int grade, Type type, LocalDate date) {
        this.grade = grade;
        this.type = type;
        this.date = date;
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(Grade o) {
        return date.compareTo(o.date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
