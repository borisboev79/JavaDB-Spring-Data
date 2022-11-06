package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student extends Person {

    @Column(nullable = false)
    private double averageGrade;

    @Column
    private int attendance;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student(){}

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
