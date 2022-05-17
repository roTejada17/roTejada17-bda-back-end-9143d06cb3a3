package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.DecomisoDto;
import com.folcamp.bancoDeAlimentos.entity.Decomiso;
import org.springframework.stereotype.Component;

@Component
public class DecomisoMapper {
    public Decomiso mapDTOToEntity (DecomisoDto decomisoDto){
        Decomiso decomiso = new Decomiso();
        decomiso.setNroRemito(decomisoDto.getNroRemito());
        decomiso.setFechaDeIngreso(decomisoDto.getFechaDeIngreso());
        decomiso.setDonante(decomisoDto.getDonante());
        decomiso.setDescripcion(decomisoDto.getDescripcion());
        return decomiso;
    }
}
