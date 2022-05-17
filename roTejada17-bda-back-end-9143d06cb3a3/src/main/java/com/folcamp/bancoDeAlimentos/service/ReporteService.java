package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.DetalleRteDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import com.folcamp.bancoDeAlimentos.mappers.ReporteMapper;
import com.folcamp.bancoDeAlimentos.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ReporteService {

    @Autowired
    ReporteRepository reporteRepository;

    @Autowired
    ReporteMapper reporteMapper;

    @Autowired
    DetalleRteService detalleRteService;

    public List<Reporte> getAll(){
        return reporteRepository.findAll();
    }

    public Optional<Reporte> getById(Integer id){
        return reporteRepository.findById(id);
    }

    public void save(Reporte reporte){
        reporteRepository.save(reporte);
    }

    public void delete(Integer id){
        reporteRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return reporteRepository.existsById(id);
    }

    public ResponseEntity update(Reporte nuevo, Integer id) {
        if (!reporteRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        nuevo.setId(id);
        return ResponseEntity.ok(reporteRepository.save(nuevo));
    }

    public List<DetalleRteDto> getDetallesById(Integer id) {
        if (Objects.nonNull(id) && reporteRepository.existsById(id))
            return detalleRteService.listByReporteId(reporteRepository.findById(id).get());
        return new ArrayList<>();
    }
}