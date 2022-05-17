package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.RemitoDto;
import com.folcamp.bancoDeAlimentos.entity.Remito;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("remitoMapper")
public class RemitoMapper {

    public RemitoDto entityToDto(Remito remito){
        return Optional.ofNullable(remito)
                .map(
                        ord -> new RemitoDto(
                                remito.getId(),
                                remito.getNroRemito(),
                                remito.getFecha(),
                                remito.getPersonales(),
                                remito.getDepartamento(),
                                remito.getOrganizacion()
                        )
                )
                .orElse(new RemitoDto());
    }
}