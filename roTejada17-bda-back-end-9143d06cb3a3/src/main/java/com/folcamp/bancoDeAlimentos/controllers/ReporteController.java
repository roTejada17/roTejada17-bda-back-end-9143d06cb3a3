package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.DetalleRteDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import com.folcamp.bancoDeAlimentos.mappers.ReporteMapper;
import com.folcamp.bancoDeAlimentos.repository.ReporteRepository;
import com.folcamp.bancoDeAlimentos.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @Autowired
    ReporteMapper reporteMapper;

    @Autowired
    ReporteRepository reporteRepository;

    @GetMapping("")
    public ResponseEntity<List<Reporte>> getList() {
        List<Reporte> list = reporteService.getAll();
        return new ResponseEntity<List<Reporte>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getById(@PathVariable("id") Integer id) {
        if (!reporteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Reporte reporte = reporteService.getById(id).get();
        return new ResponseEntity<Reporte>(reporte, HttpStatus.OK);
    }

    @GetMapping("/{id}/detalles")
    public ResponseEntity<List<DetalleRteDto>> getDetallesById(@PathVariable("id") Integer id) {
        if (!reporteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<DetalleRteDto>>(reporteService.getDetallesById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public Object create(@RequestBody Reporte reporte) {
        reporteService.save(reporte);
        return new ResponseEntity(new Mensaje("Reporte creado"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Reporte nuevo, @PathVariable("id") Integer id) {
        return reporteService.update(nuevo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (!reporteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        reporteService.delete(id);
        return new ResponseEntity(new Mensaje("Reporte eliminado"), HttpStatus.OK);
    }
}
