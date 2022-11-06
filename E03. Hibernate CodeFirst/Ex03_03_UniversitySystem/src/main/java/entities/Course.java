package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Course extends AutoId {
    @Column(unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column(nullable = false)
    private int credits;

    @ManyToMany(mappedBy = "courses", targetEntity = Student.class, cascade = CascadeType.ALL)
    private Set<Student> students;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public Course(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
