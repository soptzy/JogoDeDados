package com.example.jogodedadossophia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;
    public String email;
    public String senha;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
    public List<Bet> apostas;
}
