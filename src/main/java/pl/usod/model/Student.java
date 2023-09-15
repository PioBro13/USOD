package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="birth_date")
    private Date birthDate;

    @OneToOne(mappedBy = "student")
    @JsonManagedReference
    private OverallResults overallResults;

    @OneToOne(mappedBy = "student")
    @JsonManagedReference
    private OverallFinances overallFinances;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public OverallResults getOverallResults() {
        return overallResults;
    }

    public void setOverallResults(OverallResults overallResults) {
        this.overallResults = overallResults;
    }

    public OverallFinances getOverallFinances() {
        return overallFinances;
    }

    public void setOverallFinances(OverallFinances overallFinances) {
        this.overallFinances = overallFinances;
    }
}
