package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="birth_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private OverallResults overallResults;

    @OneToOne(mappedBy = "user")
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
