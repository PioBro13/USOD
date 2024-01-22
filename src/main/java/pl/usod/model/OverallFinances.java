package pl.usod.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "overall_finances")
public class OverallFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("userOverallFinances")
    private User user;

    @OneToMany(mappedBy = "overallFinances", cascade = CascadeType.ALL)
    @JsonManagedReference("overallFinancesTermFinances")
    private List<TermFinances> termsFinances = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User student) {
        this.user = student;
    }

    public List<TermFinances> getTermsFinances() {
        return termsFinances;
    }

    public void setTermsFinances(List<TermFinances> termsFinances) {
        this.termsFinances = termsFinances;
    }
}