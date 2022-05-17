package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.DetalleRte;
import com.folcamp.bancoDeAlimentos.mappers.DetalleRteMapper;
import com.folcamp.bancoDeAlimentos.repository.DetalleRteRepository;
import com.folcamp.bancoDeAlimentos.service.DetalleRteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/detalle")
public class DetalleRteController {

    @Autowired
    DetalleRteService detalleRteService;

    @Autowired
    DetalleRteMapper detalleRteMapper;

    @Autowired
    DetalleRteRepository detalleRteRepository;

    @GetMapping("")
    public ResponseEntity<List<DetalleRte>> getList() {
        List<DetalleRte> list = detalleRteService.getAll();
        return new ResponseEntity<List<DetalleRte>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleRte> getById(@PathVariable("id") Integer id) {
        if (!detalleRteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        DetalleRte detalleRte = detalleRteService.getById(id).get();
        return new ResponseEntity<DetalleRte>(detalleRte, HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody DetalleRte detalleRte) {
        detalleRteService.save(detalleRte);
        return new ResponseEntity(new Mensaje("Detalles de reporte creados"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody DetalleRte nuevo, @PathVariable("id") Integer id) {
        return detalleRteService.update(nuevo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!detalleRteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        detalleRteService.delete(detalleRteRepository.getById(id));
        return new ResponseEntity(new Mensaje("Detalles del reporte eliminados"), HttpStatus.OK);
    }
}
