package com.folcamp.bancoDeAlimentos.controllers;

import com.folcamp.bancoDeAlimentos.dto.EditDonanteDto;
import com.folcamp.bancoDeAlimentos.dto.NewDonanteDto;
import com.folcamp.bancoDeAlimentos.service.DonanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api/donantes")
public class DonanteController {

    @Autowired
    private DonanteService donanteService;

    //Crea donante
    @PostMapping("/nuevo")
    public ResponseEntity<?> newDonnor(@RequestBody NewDonanteDto newDonanteDto){
        return donanteService.save(newDonanteDto);
    }

    //Lista donante
    @GetMapping("/lista")
    public ResponseEntity<?> getList(){
        return donanteService.getList();
    }

    //Donante por Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getDonnorById(@PathVariable("id") Long id){
        return donanteService.getDonnorById(id);
    }

    //Editar donante
    @PutMapping("/{id}")
    public ResponseEntity<?> editDonnor(@PathVariable Long id, @RequestBody EditDonanteDto editDonanteDto){
        return  donanteService.editDonnor(id, editDonanteDto);
    }

    //Eliminar donante
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonnor(@PathVariable Long id){
        return donanteService.deleteDonnor(id);
    }
}
