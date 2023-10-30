package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name="municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_municipio;
}
