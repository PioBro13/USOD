package pl.usod.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "finances")
public class Finances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}