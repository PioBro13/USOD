package pl.usod.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "term_finances")
public class TermFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "term_id")
    @JsonBackReference
    private Term term;

    @ManyToOne
    @JoinColumn(name="overall_finances_id")
    @JsonBackReference
    private OverallFinances overallFinances;

}
