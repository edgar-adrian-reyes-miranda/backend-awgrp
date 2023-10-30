package com.awrg.awgrp.Repository;

import com.awrg.awgrp.Entity.Usuarios;
import com.awrg.awgrp.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo  extends JpaRepository<User, Long> {
}
