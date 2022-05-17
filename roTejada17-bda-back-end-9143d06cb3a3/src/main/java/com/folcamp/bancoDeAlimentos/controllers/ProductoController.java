package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.ProductoDto;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.mappers.ProductoMapper;
import com.folcamp.bancoDeAlimentos.repository.ProductoRepository;
import com.folcamp.bancoDeAlimentos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoMapper productoMapper;

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("")
    public ResponseEntity<List<ProductoDto>> getList() {
        List<ProductoDto> list = productoService.getAll();
        return new ResponseEntity<List<ProductoDto>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") Integer id) {
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getById(id).get();
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    /*@GetMapping("/detailname/{nombre}")
    public ResponseEntity<Producto> getByName(@PathVariable("nombre") String name){
        if(!productoService.existsByName(name))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Producto producto = productoService.getByName(name).get();
        return new ResponseEntity(producto, HttpStatus.OK);
    }*/


    @PostMapping("")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public Object create(@RequestBody Producto producto) {
        if (!StringUtils.hasText(producto.getName())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (productoService.existsByName(producto.getName()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        productoService.save(producto);
        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id,@RequestBody Producto nuevo) {
        if (!productoService.existsById(id))
            return new ResponseEntity<>("No existe producto con ese id", HttpStatus.NOT_FOUND);
        else {
            Producto viejo = productoRepository.findById(id).get();
            if (viejo.getName().equals(nuevo.getName())) {
                if (!nuevo.getName().isEmpty())

                    if (Objects.nonNull(nuevo.getPerecedero()))

                        if (nuevo.getValorNutricional() != null) {
                            productoService.save(nuevo);
                            return new ResponseEntity<>(nuevo, HttpStatus.OK);
                        }
                return ResponseEntity.unprocessableEntity().build();
            } else if (!productoRepository.existsByName(nuevo.getName()))
                if (!nuevo.getName().isEmpty())

                    if (Objects.nonNull(nuevo.getPerecedero()))

                        if (nuevo.getValorNutricional() != null) {
                            productoService.save(nuevo);
                            return new ResponseEntity<>(nuevo, HttpStatus.OK);
                        }
            return ResponseEntity.unprocessableEntity().build();
        }
    }


    @DeleteMapping("/{id}")
    /*@PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        if (!productoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        productoService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
