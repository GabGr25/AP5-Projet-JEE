package lab07.web.dto;

import lab07.web.data.Grade;

import java.util.List;

public class StudentDTO {

    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private List<GradeDTO> grades;

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

    public List<GradeDTO> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDTO> grades) {
        this.grades = grades;
    }
}
