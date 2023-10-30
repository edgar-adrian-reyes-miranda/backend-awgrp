package com.awrg.awgrp.Controller;

import com.awrg.awgrp.Security.AuthResponse;
import com.awrg.awgrp.Security.LoginRequest;
import com.awrg.awgrp.Security.RegistroRequest;
import com.awrg.awgrp.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class RolesController {

    private  final AuthService authService;
    @PostMapping(value ="login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value="registre")
    public ResponseEntity<AuthResponse> registro(@RequestBody RegistroRequest request){
        return ResponseEntity.ok(authService.registre(request));
    }


}
