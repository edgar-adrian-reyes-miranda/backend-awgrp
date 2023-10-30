package com.awrg.awgrp.Controller;
import com.awrg.awgrp.DTO.DatosPerDTO;
import com.awrg.awgrp.Entity.DatosPersonales;
import com.awrg.awgrp.Services.DatosPersonalesServices;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DatosPersoController {
    private DatosPersonalesServices datosperServices;

    ////consulta
    @GetMapping("/DatosPersonales")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosPersonales>consulta(){
        return datosperServices.findAll();
    }

    @GetMapping("/DatosPersonales/{id}")
    public ResponseEntity<?>consultaPorID(@PathVariable Long id){
        DatosPersonales datospersonales=null;
        String reponse="";
        try {
            datospersonales=datosperServices.findById(id);
        } catch (DataAccessException e) {
            reponse="error al consultar";
            reponse = reponse.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<String>(reponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(datospersonales== null) {
            reponse="El dato personal con el id".concat(id.toString().concat("no existe en la base de datos"));
            return new ResponseEntity<String>(reponse, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(reponse, HttpStatus.OK);
    }
    /////ELIMINACION
    @DeleteMapping("/DatosPersonales/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        Map<String, Object> response= new HashMap<>();
        try {
            DatosPersonales datosperdelete=this.datosperServices.findById(id);
            if(datosperdelete==null){
                response.put("mensaje", "error al eliminar. El dato personal no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            datosperServices.delete(id);
        }catch (DataAccessException e) {
            response.put("mensaje", "error al eliminar de la base de datos");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));

        }
        response.put("mensaje", "Dato personal eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    ///////////INSERTAR
    @PostMapping("/DatosPersonales")
    public ResponseEntity<?> create(@RequestBody DatosPerDTO clientes) {
       DatosPersonales datospersonalesnew = null;
        Map<String, Object> response = new HashMap<>();

        try {
            datospersonalesnew = this.datosperServices.creCliente(clientes);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error en la inserción");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Cliente insertado con éxito, con el id");
        response.put("cliente", datospersonalesnew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //////editar

    @PutMapping("/DatoPersonal/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DatosPerDTO datosperDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            DatosPersonales datospersonalesedit = datosperServices.findById(id);
            if (datospersonalesedit == null) {
                response.put("mensaje", "Error al actualizar. El cliente con el ID " + id + " no existe.");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            datosperServices.actualizarCliente(id, datosperDTO);
            response.put("mensaje", "Cliente actualizado con éxito.");
            response.put("cliente", datospersonalesedit);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el dato personal.");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().toString()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
