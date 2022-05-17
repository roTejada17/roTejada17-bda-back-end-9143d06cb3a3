package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.NewDonanteDto;
import com.folcamp.bancoDeAlimentos.entity.Donante;
import org.springframework.stereotype.Component;

@Component
public class DonanteMapper {
    public Donante mapDTOToEntity (NewDonanteDto donnorDto){
        Donante donante = new Donante();
        donante.setCc(donnorDto.getCc());
        donante.setName(donnorDto.getName());
        donante.setPhoneNumber(donnorDto.getPhoneNumber());
        donante.setAddress(donnorDto.getAddress());
        return donante;
    }
}
