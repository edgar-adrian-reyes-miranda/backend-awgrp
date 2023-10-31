package com.awrg.awgrp.Repository;

import com.awrg.awgrp.Entity.Usuarios;
import com.awrg.awgrp.User.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo  extends JpaRepository<User, Long> {
    Optional<User>findAllByUsername(String username);
}
