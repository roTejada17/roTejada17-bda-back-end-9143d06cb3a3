package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.OrganizacionDto;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;
//import com.folcamp.bancoDeAlimentos.mappers.OrganizacionMapper;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.repository.OrganizacionRepository;
import com.folcamp.bancoDeAlimentos.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/organizacion")
public class OrganizacionController {
    @Autowired
    OrganizacionService organizacionService;
    /*
        @Autowired
        OrganizacionMapper organizacionMapper;
    */
    @Autowired
    OrganizacionRepository organizacionRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<OrganizacionDto>> getList() {
        List<OrganizacionDto> list = organizacionService.getAll();
        return new ResponseEntity<List<OrganizacionDto>>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody Organizacion organizacion) {
        if (!StringUtils.hasText(organizacion.getName())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(organizacion.getStreetAddress())) {
            return new ResponseEntity(new Mensaje("la calle es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(organizacion.getDeptoAddress())) {
            return new ResponseEntity(new Mensaje("el departamento es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        organizacionService.save(organizacion);
        return new ResponseEntity(organizacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (!organizacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        organizacionService.delete(id);
        return new ResponseEntity(new Mensaje("Organizacion eliminada"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody Organizacion nuevo) {

        Organizacion viejo = organizacionRepository.findById(id).get();
        if (viejo.getName().equals(nuevo.getName())) {
            if (!nuevo.getName().isEmpty()) {
                nuevo.setId(id);
                organizacionService.save(nuevo);
                return new ResponseEntity<>(nuevo, HttpStatus.OK);
            }
        }
        else{
        return new ResponseEntity<>(new Mensaje("no se encontro"),HttpStatus.BAD_REQUEST);}
        return null;
    }
    }
