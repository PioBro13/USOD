package pl.usod.model;

import jakarta.persistence.*;

@Entity
@Table(name = "operation_finances")
public class OperationFinances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
