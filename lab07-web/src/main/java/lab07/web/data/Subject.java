package lab07.web.data;

import java.util.List;
import java.util.Objects;

public class Subject implements Comparable<Subject>{

    private long id;

    private String name;

    private int weight;

    private List<Grade> grades;

    public Subject() {
    }

    public Subject(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public double getAverage() {
        double sumOfGrades = 0;
        double sumOfWeights = 0;
        for (Grade grade : grades) {
            sumOfGrades += grade.getType().getWeight() * grade.getGrade();
            sumOfWeights += grade.getType().getWeight();
        }
        return sumOfGrades / sumOfWeights;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id && weight == subject.weight && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }

    @Override
    public int compareTo(Subject o) {
        return name.compareTo(o.name);
    }
}
