package com.awrg.awgrp.Security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroRequest {
    String nombreUsuario;
    String password;
    String correoPersonal;

}
