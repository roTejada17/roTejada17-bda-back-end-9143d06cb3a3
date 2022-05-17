package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.entity.Categoria;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.repository.CategoriaRepository;
import com.folcamp.bancoDeAlimentos.service.CategoriaService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;


    @GetMapping("")
    public ResponseEntity<List<Categoria>> getList() {
        List<Categoria> list = categoriaService.getAll();
        return new ResponseEntity<List<Categoria>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable("id") Integer id) {
        if (!categoriaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Categoria categoria = categoriaService.getById(id).get();
        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        if (StringUtils.isBlank(categoria.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (categoriaService.existsByName(categoria.getName()))
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        categoriaService.save(categoria);
        return new ResponseEntity(new Mensaje("Categoria creada"), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        if(!categoriaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        categoriaService.delete(id);
        return new ResponseEntity(new Mensaje("Categoria eliminada"), HttpStatus.OK);
    }
}
