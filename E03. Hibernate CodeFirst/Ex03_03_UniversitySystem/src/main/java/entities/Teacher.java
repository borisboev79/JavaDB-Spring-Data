package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Teacher extends Person{
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class, cascade = CascadeType.ALL)
    private Set<Course> courses;

    public Teacher(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
