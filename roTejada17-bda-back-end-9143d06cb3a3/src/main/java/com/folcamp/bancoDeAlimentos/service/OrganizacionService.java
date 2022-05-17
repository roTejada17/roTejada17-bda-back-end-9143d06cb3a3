package com.folcamp.bancoDeAlimentos.service;


import com.folcamp.bancoDeAlimentos.dto.OrganizacionDto;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;

import com.folcamp.bancoDeAlimentos.mappers.OrganizacionMapper;
import com.folcamp.bancoDeAlimentos.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrganizacionService {
    @Autowired
    OrganizacionRepository organizacionRepository;
    @Autowired
    OrganizacionMapper organizacionMapper;

    public List<OrganizacionDto> getAll() {
        return organizacionRepository.findAll().stream().map(organizacionMapper::entityToDto).collect(Collectors.toList());
    }

    public void save(Organizacion organizacion) {
        organizacionRepository.save(organizacion);
    }

    public boolean existsById(Integer id){
        return organizacionRepository.existsById(id);
    }


    public void delete(Integer id) {
        organizacionRepository.deleteById(id);
    }
}
