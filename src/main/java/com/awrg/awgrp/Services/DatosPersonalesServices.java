package com.awrg.awgrp.Services;

import com.awrg.awgrp.DTO.DatosPerDTO;
import com.awrg.awgrp.Entity.DatosPersonales;
import com.awrg.awgrp.Repository.DatosPersonalesRespo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DatosPersonalesServices {
    private DatosPersonalesRespo datosperrespon;

    //consulta general
    @Transactional(readOnly = true)
    public List<DatosPersonales> findAll(){
        return(List<DatosPersonales>)datosperrespon.findAll();
    }

    //consulta por id
    @Transactional (readOnly= true)
    public DatosPersonales findById(Long id){
        return (DatosPersonales) datosperrespon.findById(id).orElse(null);
    }

    //nuevo cliente
    public DatosPersonales creCliente(DatosPerDTO datosperson) {
        DatosPersonales Entity= new DatosPersonales();
        Entity.setNombre(datosperson.getNombre());
        Entity.setApellido_p(datosperson.getApellido_p());
        Entity.setApellido_s(datosperson.getApellido_s());
        Entity.setTelefonocasa(datosperson.getTelefonocasa());
        Entity.setTelefonopersonal(datosperson.getTelefonopersonal());
        Entity.setCURP(datosperson.getCURP());
        Entity.setDireccion(datosperson.getDireccion());
        return datosperrespon.save(Entity);

    }


    //eliminar cliente
    public void delete(Long id){
        datosperrespon.deleteById(id);
    }


    //actualizar cliente
    @Transactional
    public DatosPersonales actualizarCliente(Long id, DatosPerDTO datospersoActualizado) {
        DatosPersonales datospersonExistente = findById(id);
        datospersonExistente.setNombre(datospersoActualizado.getNombre());
        datospersonExistente.setApellido_p(datospersoActualizado.getApellido_p());
        datospersonExistente.setApellido_s(datospersoActualizado.getApellido_s());
        datospersonExistente.setTelefonocasa(datospersoActualizado.getTelefonocasa());
        datospersonExistente.setTelefonopersonal(datospersoActualizado.getTelefonopersonal());
        datospersonExistente.setCURP(datospersoActualizado.getCURP());
        datospersonExistente.setDireccion(datospersoActualizado.getDireccion());
        return datosperrespon.save(datospersonExistente);
    }
}
