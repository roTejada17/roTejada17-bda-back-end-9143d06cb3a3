package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.OrganizacionDto;
import com.folcamp.bancoDeAlimentos.dto.PersonalesDto;
import com.folcamp.bancoDeAlimentos.entity.Categoria;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import com.folcamp.bancoDeAlimentos.entity.Personales;
import com.folcamp.bancoDeAlimentos.mappers.OrganizacionMapper;
import com.folcamp.bancoDeAlimentos.mappers.PersonalesMapper;
import com.folcamp.bancoDeAlimentos.mappers.ProductoMapper;
import com.folcamp.bancoDeAlimentos.repository.OrganizacionRepository;
import com.folcamp.bancoDeAlimentos.repository.PersonalesRepository;
import com.folcamp.bancoDeAlimentos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalesService {
    @Autowired
    PersonalesRepository personalesRepository;
    @Autowired
    OrganizacionService organizacionService;
    @Autowired
    OrganizacionRepository organizacionRepository;
    @Autowired
    PersonalesMapper personalesMapper;

    public void save(Personales personales) {
        personalesRepository.save(personales);
    }


    public boolean existsByName(String name) {
        return personalesRepository.existsByName(name);
    }

    public void delete(Integer id) {
        personalesRepository.deleteById(id);
    }

    public List<PersonalesDto> getAll() {
        List<PersonalesDto> list = personalesRepository.findAll().stream().map(personalesMapper::mapEntityToDto).collect(Collectors.toList());
        return list;
    }
}

