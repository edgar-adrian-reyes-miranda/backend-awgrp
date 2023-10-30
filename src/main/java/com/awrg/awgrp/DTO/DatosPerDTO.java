package com.awrg.awgrp.DTO;

import java.io.Serializable;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DatosPerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido_p;
    private String apellido_s;
    private String direccion;
    private String CURP;
    private int telefonocasa;
    private int telefonopersonal;

}


