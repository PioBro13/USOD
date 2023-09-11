package pl.usod.model;


import jakarta.persistence.*;

@Entity
@Table(name = "term_finances")
public class TermFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
