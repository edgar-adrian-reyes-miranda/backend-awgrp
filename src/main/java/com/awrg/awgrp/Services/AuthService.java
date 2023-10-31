package com.awrg.awgrp.Services;

import com.awrg.awgrp.JWTAuthenticatorFilter.JwtService;
import com.awrg.awgrp.Repository.UsuarioRepo;
import com.awrg.awgrp.Security.AuthResponse;
import com.awrg.awgrp.Security.LoginRequest;
import com.awrg.awgrp.Security.RegistroRequest;
import com.awrg.awgrp.User.Role;
import com.awrg.awgrp.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepo userRepository;
    private final PasswordEncoder  passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombreusuario(), request.getPassword()));
        UserDetails user=userRepository.findAllByUsername(request.getNombreusuario()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse registre(RegistroRequest request) {
        User user=User.builder()
                .nombreUsuario(request.getNombreUsuario())
                .password(passwordEncoder.encode(request.getPassword()))
                .correoPersonal(request.getCorreoPersonal())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
