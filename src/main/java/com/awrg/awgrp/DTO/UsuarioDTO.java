package com.awrg.awgrp.DTO;

import java.io.Serializable;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombreUsu;
    private String password;
    private String correop;


}