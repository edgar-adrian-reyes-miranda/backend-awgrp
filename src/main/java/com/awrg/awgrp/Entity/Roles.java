package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;
    private String tipo_rol;
}
