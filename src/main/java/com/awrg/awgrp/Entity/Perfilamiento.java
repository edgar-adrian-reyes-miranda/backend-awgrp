package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name="perfilamiento")
public class Perfilamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPerfilamiento;
}
