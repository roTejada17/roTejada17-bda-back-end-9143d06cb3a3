package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Decomiso;
import com.folcamp.bancoDeAlimentos.mappers.DecomisoMapper;
import com.folcamp.bancoDeAlimentos.repository.DecomisoRepository;
import com.folcamp.bancoDeAlimentos.service.DecomisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/decomiso")
public class DecomisoController {

    @Autowired
    DecomisoMapper decomisoMapper;

    @Autowired
    DecomisoRepository decomisoRepository;

    @Autowired
    DecomisoService decomisoService;

    @GetMapping("")
    public ResponseEntity<List<Decomiso>> getList() {
        List<Decomiso> list = decomisoService.getAll();
        return new ResponseEntity<List<Decomiso>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Decomiso> getById(@PathVariable("id") Integer id) {
        if (!decomisoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Decomiso decomiso = decomisoService.getById(id).get();
        return new ResponseEntity<Decomiso>(decomiso, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody Decomiso decomiso) {
        decomisoService.save(decomiso);
        return new ResponseEntity(new Mensaje("Documento de decomiso creado"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Decomiso nuevo, @PathVariable("id") Integer id) {
        return decomisoService.update(nuevo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!decomisoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        decomisoService.delete(id);
        return new ResponseEntity(new Mensaje("Documento de decomiso eliminado"), HttpStatus.OK);
    }
}
