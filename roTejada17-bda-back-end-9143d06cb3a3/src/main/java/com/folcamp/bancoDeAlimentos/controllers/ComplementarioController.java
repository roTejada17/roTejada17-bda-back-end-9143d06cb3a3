package com.folcamp.bancoDeAlimentos.controllers;


import com.folcamp.bancoDeAlimentos.dto.ComplementarioDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Complementario;
import com.folcamp.bancoDeAlimentos.repository.ComplementarioRepository;
import com.folcamp.bancoDeAlimentos.repository.OrganizacionRepository;
import com.folcamp.bancoDeAlimentos.service.ComplementarioService;
import com.folcamp.bancoDeAlimentos.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/complementario")
public class ComplementarioController {
    @Autowired
    OrganizacionService organizacionService;
    @Autowired
    OrganizacionRepository organizacionRepository;
    @Autowired
    ComplementarioService complementarioService;
    @Autowired
    ComplementarioRepository complementarioRepository;

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody Complementario nuevo) {
        if (!organizacionRepository.existsById(id))
            return new ResponseEntity<>("No existe organizacion con el id provisto", HttpStatus.NOT_FOUND);
        else {
            nuevo.setId(id);
            complementarioService.save(nuevo);
            return new ResponseEntity<>("Se guardo complementario", HttpStatus.ACCEPTED);

        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ComplementarioDto>> getList() {
        List<ComplementarioDto> list = complementarioService.getAll();
        return new ResponseEntity<List<ComplementarioDto>>(list, HttpStatus.OK);
    }
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!complementarioRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        complementarioService.delete(id);
        return new ResponseEntity(new Mensaje("Categoria eliminada"), HttpStatus.OK);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        if (!complementarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
       Optional<Complementario> complementario = complementarioRepository.findById(id);
        return new ResponseEntity<Optional<Complementario>>(complementario, HttpStatus.OK);
    }
}
