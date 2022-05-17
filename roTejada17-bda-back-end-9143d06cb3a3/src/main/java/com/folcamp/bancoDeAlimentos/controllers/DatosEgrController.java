package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.DatosRem;
import com.folcamp.bancoDeAlimentos.mappers.DatosRemMapper;
import com.folcamp.bancoDeAlimentos.repository.DatosRemRepository;
import com.folcamp.bancoDeAlimentos.service.DatosRemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/datos")
public class DatosEgrController {

    @Autowired
    DatosRemService datosRemService;

    @Autowired
    DatosRemMapper datosRemMapper;

    @Autowired
    DatosRemRepository datosRemRepository;

    @GetMapping("")
    public ResponseEntity<List<DatosRem>> getList() {
        List<DatosRem> list = datosRemService.getAll();
        return new ResponseEntity<List<DatosRem>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRem> getById(@PathVariable("id") Integer id) {
        if (!datosRemService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        DatosRem datosRem = datosRemService.getById(id).get();
        return new ResponseEntity<DatosRem>(datosRem, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody DatosRem datosRem) {
        datosRemService.save(datosRem);
        return new ResponseEntity(new Mensaje("Datos de remito creados"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody DatosRem nuevo, @PathVariable("id") Integer id) {
        return datosRemService.update(nuevo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!datosRemService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        datosRemService.delete(datosRemRepository.getById(id));
        return new ResponseEntity(new Mensaje("Datos del remito eliminados"), HttpStatus.OK);
    }
}
