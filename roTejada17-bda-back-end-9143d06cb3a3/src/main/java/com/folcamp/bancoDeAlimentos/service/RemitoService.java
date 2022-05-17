package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.DatosRemDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.RemitoDto;
import com.folcamp.bancoDeAlimentos.entity.Remito;
import com.folcamp.bancoDeAlimentos.mappers.RemitoMapper;
import com.folcamp.bancoDeAlimentos.repository.RemitoRepository;
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
public class RemitoService {

    @Autowired
    RemitoRepository remitoRepository;

    @Autowired
    RemitoMapper remitoMapper;

    @Autowired
    DatosRemService datosRemService;

    public List<Remito> getAll(){
        return remitoRepository.findAll();
    }

    public Optional<Remito> getById(Integer id){
        return remitoRepository.findById(id);
    }

    public void save(Remito remito){
        remitoRepository.save(remito);
    }

    public void delete(Integer id){
        remitoRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return remitoRepository.existsById(id);
    }

    public ResponseEntity update(Remito nuevo, Integer id) {
        if (!remitoRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        nuevo.setId(id);
        return ResponseEntity.ok(remitoRepository.save(nuevo));
    }

    public List<DatosRemDto> getDetallesById(Integer id) {
        if (Objects.nonNull(id) && remitoRepository.existsById(id))
            return datosRemService.listByRemitoId(remitoRepository.findById(id).get());
        return new ArrayList<>();
    }

}