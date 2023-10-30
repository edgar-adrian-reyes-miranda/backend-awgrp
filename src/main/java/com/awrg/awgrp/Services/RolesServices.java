package com.awrg.awgrp.Services;
import com.awrg.awgrp.DTO.RolesDTO;
import com.awrg.awgrp.Entity.Roles;
import com.awrg.awgrp.Repository.RolesRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RolesServices {
    private RolesRepo rolreponse;
    //cunsulta general
    @Transactional(readOnly = true)
    public List<Roles>findAll(){
        return(List<Roles>)rolreponse.findAll();
    }

    //consulta
    @Transactional(readOnly =true)
    public Roles findById(Long id) {
        return(Roles)rolreponse.findById(id).orElse(null);
    }

    //nuevo cliente
    public Roles creRoles(RolesDTO rol) {
        Roles Entity= new Roles();
        Entity.setTipo_rol(rol.getTiporol());
        return rolreponse.save(Entity);

    }


    //eliminar cliente
    public void delete(Long id){
        rolreponse.deleteById(id);
    }


    //actualizar cliente
    @Transactional
    public Roles actualizarrRol(Long id, RolesDTO RolActualizado) {
        Roles RolExistente = findById(id);
        RolExistente.setTipo_rol(RolActualizado.getTiporol());
        return rolreponse.save(RolExistente);
    }

}
