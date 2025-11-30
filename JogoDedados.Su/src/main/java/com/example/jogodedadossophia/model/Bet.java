package com.example.jogodedadossophia.model;

import jakarta.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String titulo;
    public Integer valor;
    public Boolean ganhou;

    @ManyToOne
    @JoinColumn(name="user_id")
    public User dono;
}
