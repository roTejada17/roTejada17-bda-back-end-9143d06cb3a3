package com.folcamp.bancoDeAlimentos.service;

import com.folcamp.bancoDeAlimentos.entity.Rol;
import com.folcamp.bancoDeAlimentos.enums.RolName;
import com.folcamp.bancoDeAlimentos.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service/*("rolService")*/
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}