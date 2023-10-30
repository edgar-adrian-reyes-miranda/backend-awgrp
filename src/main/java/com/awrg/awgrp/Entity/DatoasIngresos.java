package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name = "datosingresos")
public class DatoasIngresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horaios;
    private String cv;
    private String historialAcademico;

}
