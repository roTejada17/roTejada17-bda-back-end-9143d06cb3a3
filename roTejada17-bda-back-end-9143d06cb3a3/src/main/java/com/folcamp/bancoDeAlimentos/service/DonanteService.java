package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.dto.EditDonanteDto;
import com.folcamp.bancoDeAlimentos.dto.Mensaje;
import com.folcamp.bancoDeAlimentos.dto.NewDonanteDto;
import com.folcamp.bancoDeAlimentos.entity.Donante;
import com.folcamp.bancoDeAlimentos.mappers.DonanteMapper;
import com.folcamp.bancoDeAlimentos.repository.DonanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DonanteService {

    @Autowired
    private DonanteRepository donanteRepository;
    @Autowired
    private DonanteMapper donanteMapper;

    //crear
    public ResponseEntity<?> save(NewDonanteDto newDonanteDto){
        try{
            if (newDonanteDto.getName() == null)
                return new ResponseEntity<>("El nombre es obligatorio",HttpStatus.BAD_REQUEST);

            if (newDonanteDto.getName().isBlank())
                return new ResponseEntity<>("El nombre es obligatorio",HttpStatus.BAD_REQUEST);

            if (newDonanteDto.getAddress() == null)
                return new ResponseEntity<>("La direccion es obligatoria",HttpStatus.BAD_REQUEST);

            if (newDonanteDto.getAddress().isBlank())
                return new ResponseEntity<>("La direccion es obligatoria",HttpStatus.BAD_REQUEST);

            if (newDonanteDto.getPhoneNumber() == null)
                return new ResponseEntity<>("El numero de telefono es obligatorio", HttpStatus.BAD_REQUEST);

            if (newDonanteDto.getPhoneNumber().isBlank())
                return new ResponseEntity<>("El numero de telefono es obligatorio", HttpStatus.BAD_REQUEST);

            Donante donante = donanteMapper.mapDTOToEntity(newDonanteDto);
            donanteRepository.save(donante);
            return new ResponseEntity<>(donante,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //lista
    public ResponseEntity<?> getList(){
        List<Donante> donanteList = donanteRepository.findAll();
        return new ResponseEntity<>(donanteList,HttpStatus.OK);
    }

    //view
    public ResponseEntity<?> getDonnorById(Long id){
        if (!donanteRepository.existsById(id)){
            return new ResponseEntity<>("El usuario donante con ese id no existe",HttpStatus.BAD_REQUEST);
        }
        Donante donante = donanteRepository.findById(id).get();
        return new ResponseEntity<>(donante,HttpStatus.OK);
    }

    //edit
    public ResponseEntity<?> editDonnor(Long id, EditDonanteDto editDonanteDto){
        try{
            if (!donanteRepository.existsById(id))
                return new ResponseEntity<>("No existe donante con ese id", HttpStatus.BAD_REQUEST);

            Donante donante = donanteRepository.findById(id).get();

            if ((editDonanteDto.getCc() != null) && (!editDonanteDto.getCc().toString().isEmpty())){
                donante.setCc(editDonanteDto.getCc());
            }

            if ((editDonanteDto.getCc() == null) || (editDonanteDto.getCc().isBlank())){
                donante.setCc("-");
            }

            if (!editDonanteDto.getName().isEmpty())
                donante.setName(editDonanteDto.getName());

            if (!editDonanteDto.getPhoneNumber().toString().isEmpty())
                donante.setPhoneNumber(editDonanteDto.getPhoneNumber());

            if (!editDonanteDto.getAddress().isEmpty())
                donante.setAddress(editDonanteDto.getAddress());

            donanteRepository.save(donante);
            return new ResponseEntity<>(donante, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete
    public ResponseEntity<?> deleteDonnor(Long id){
        if (!donanteRepository.existsById(id))
            return new ResponseEntity<>(new Mensaje("El donante que desea eliminar no existe"),HttpStatus.BAD_REQUEST);

        //Donante donante = donanteRepository.findById(id).get();
        donanteRepository.deleteById(id);
        return new ResponseEntity<>(new Mensaje("Donante eliminado"), HttpStatus.OK);
    }
}
