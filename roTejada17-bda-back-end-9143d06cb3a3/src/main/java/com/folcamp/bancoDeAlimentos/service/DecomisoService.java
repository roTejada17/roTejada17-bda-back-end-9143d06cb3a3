package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Decomiso;
import com.folcamp.bancoDeAlimentos.mappers.DecomisoMapper;
import com.folcamp.bancoDeAlimentos.repository.DecomisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DecomisoService {
    @Autowired
    DecomisoRepository decomisoRepository;
    @Autowired
    DecomisoMapper decomisoMapper;

    public List<Decomiso> getAll(){
        return decomisoRepository.findAll();
    }

    public Optional<Decomiso> getById(Integer id){
        return decomisoRepository.findById(id);
    }


    public void save(Decomiso decomiso){
        decomisoRepository.save(decomiso);
    }

    public void delete(Integer id){
        decomisoRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return decomisoRepository.existsById(id);
    }


    public ResponseEntity update(Decomiso nuevo, Integer id) {
        if (!decomisoRepository.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        nuevo.setId(id);
        return ResponseEntity.ok(decomisoRepository.save(nuevo));
    }
}
