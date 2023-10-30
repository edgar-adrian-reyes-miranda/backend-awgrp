package com.awrg.awgrp.Repository;

import com.awrg.awgrp.Entity.DatosPersonales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosPersonalesRespo extends JpaRepository<DatosPersonales, Long> {
}
