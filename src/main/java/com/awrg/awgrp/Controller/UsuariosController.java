package com.awrg.awgrp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {

    @PostMapping(value ="/administrador")  // Corregido el nombre y mejorado el mapeo
    public String bienvenido() {
        return "¡Bienvenido a la sección de administradores!";
    }
}
