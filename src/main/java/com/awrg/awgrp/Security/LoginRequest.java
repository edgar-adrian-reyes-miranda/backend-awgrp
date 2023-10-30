package com.awrg.awgrp.Security;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    String nombreusuario;
    String password;
}
