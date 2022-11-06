package entities;

import auxiliary.AutoId;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Patient extends AutoId {
    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 150)
    private String address;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(length = 500)
    private String picture;

    @Column(nullable = false)
    private boolean isInsured;

    @OneToMany(mappedBy = "patient", targetEntity = Visitation.class, cascade = CascadeType.ALL)
    private Set<Visitation> visitations;

    public Patient(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
