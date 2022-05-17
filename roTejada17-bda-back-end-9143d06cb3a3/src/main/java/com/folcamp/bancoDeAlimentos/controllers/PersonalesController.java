package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.PersonalesDto;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import com.folcamp.bancoDeAlimentos.entity.Personales;
import com.folcamp.bancoDeAlimentos.repository.PersonalesRepository;
import com.folcamp.bancoDeAlimentos.service.PersonalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/personales")
public class PersonalesController {

    private final PersonalesService personalesService;
    private final PersonalesRepository personalesRepository;

    public PersonalesController(PersonalesService personalesService, PersonalesRepository personalesRepository) {
        this.personalesService = personalesService;
        this.personalesRepository = personalesRepository;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Personales personales) {
        if (!StringUtils.hasText(personales.getName())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(personales.getNumberCell())) {
            return new ResponseEntity(new Mensaje("el numero de celular es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        personalesService.save(personales);
        return new ResponseEntity(new Mensaje("Personal creado"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!personalesRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        personalesService.delete(id);
        return new ResponseEntity(new Mensaje("Personal Eliminado"), HttpStatus.OK);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<PersonalesDto>> getList() {
        List<PersonalesDto> list = personalesService.getAll();
        return new ResponseEntity<List<PersonalesDto>>(list, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody Personales nuevo) {

        Personales viejo = personalesRepository.findById(id).get();
        if (viejo.getName().equals(nuevo.getName())) {
            if (!nuevo.getName().isEmpty()) {
                nuevo.setId(id);
                personalesService.save(nuevo);
                return new ResponseEntity<>(new Mensaje("se actualizo Personal"), HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(new Mensaje("no se encontro"),HttpStatus.BAD_REQUEST);}
        return null;
    }
}
