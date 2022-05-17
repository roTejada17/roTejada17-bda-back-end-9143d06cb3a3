package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.ProductoDto;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.mappers.ProductoMapper;
import com.folcamp.bancoDeAlimentos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ProductoMapper productoMapper;

    public List<ProductoDto> getAll(){
        return productoRepository.findAll().stream().map(productoMapper::entityToDto).collect(Collectors.toList());
    }

    public Optional<Producto> getById(Integer id){
        return productoRepository.findById(id);
    }

    public Optional<Producto> getByName(String name){
        return productoRepository.findByName(name);
    }

    public void save(Producto producto){
        productoRepository.save(producto);
    }

    public void delete(Integer id){
        productoRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return productoRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return productoRepository.existsByName(name);
    }
}
