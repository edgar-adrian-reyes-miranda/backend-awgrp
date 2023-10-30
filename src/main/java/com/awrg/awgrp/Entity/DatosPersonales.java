package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="datospersonales")
public class DatosPersonales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido_p;
    private String apellido_s;
    private String direccion;
    private String CURP;
    private int telefonocasa;
    private int telefonopersonal;

}
