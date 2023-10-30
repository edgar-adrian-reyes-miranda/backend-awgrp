package com.awrg.awgrp.Services;

import com.awrg.awgrp.Security.AuthResponse;
import com.awrg.awgrp.Security.LoginRequest;
import com.awrg.awgrp.Security.RegistroRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse registre(RegistroRequest request) {
        return null;
    }
}
