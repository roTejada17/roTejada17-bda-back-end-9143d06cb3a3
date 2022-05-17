package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.entity.Categoria;
import com.folcamp.bancoDeAlimentos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> getAll(){
        List<Categoria> list=categoriaRepository.findAll();
        return list;
    }

    public Optional<Categoria> getById(Integer id){
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> getByName(String name){
        return categoriaRepository.findByName(name);
    }

    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public void delete(Integer id){
        categoriaRepository.deleteById(id);
    }

    public boolean existsById(Integer id){
        return categoriaRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return categoriaRepository.existsByName(name);
    }
}
