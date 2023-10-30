package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name="datoEscolares")
public class DatosEscolares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String correo_institucional;
    private String periodo;
    private int matriculaEscolar;
    private String modalidadEscolar;

}
