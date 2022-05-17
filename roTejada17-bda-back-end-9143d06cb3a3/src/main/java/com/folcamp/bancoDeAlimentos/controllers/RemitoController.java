package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.DatosRemDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Remito;
import com.folcamp.bancoDeAlimentos.service.RemitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/remito")
public class RemitoController {

    @Autowired
    RemitoService remitoService;

    @GetMapping("")
    public ResponseEntity<List<Remito>> getList() {
        List<Remito> list = remitoService.getAll();
        return new ResponseEntity<List<Remito>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Remito> getById(@PathVariable("id") Integer id) {
        if (!remitoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Remito remito = remitoService.getById(id).get();
        return new ResponseEntity<Remito>(remito, HttpStatus.OK);
    }

    @GetMapping("/{id}/datos")
    public ResponseEntity<List<DatosRemDto>> getDetallesById(@PathVariable("id") Integer id) {
        if (!remitoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<DatosRemDto>>(remitoService.getDetallesById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody Remito remito) {
        remitoService.save(remito);
        return new ResponseEntity(new Mensaje("Remito creado"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Remito nuevo, @PathVariable("id") Integer id) {
        return remitoService.update(nuevo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (!remitoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        remitoService.delete(id);
        return new ResponseEntity(new Mensaje("Remito eliminado"), HttpStatus.OK);
    }
}