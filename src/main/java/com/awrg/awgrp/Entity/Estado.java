package com.awrg.awgrp.Entity;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue()
    private Long id;
    private String nombreEstado;
}
