package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.ComplementarioDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.ProductoDto;
import com.folcamp.bancoDeAlimentos.entity.Complementario;
import com.folcamp.bancoDeAlimentos.mappers.ComplementarioMapper;
import com.folcamp.bancoDeAlimentos.repository.ComplementarioRepository;
import com.folcamp.bancoDeAlimentos.repository.PersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComplementarioService {
    @Autowired
    ComplementarioRepository complementarioRepository;
    @Autowired
    ComplementarioMapper complementarioMapper;

    public void save(Complementario complementario) {
        complementarioRepository.save(complementario);
    }

    public List<ComplementarioDto> getAll() {
        return complementarioRepository.findAll().stream().map(complementarioMapper::entityToDto).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        complementarioRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return complementarioRepository.existsById(id);
    }


    public Optional<Complementario> findById(Integer id){
        return complementarioRepository.findById(id);
    }

}
