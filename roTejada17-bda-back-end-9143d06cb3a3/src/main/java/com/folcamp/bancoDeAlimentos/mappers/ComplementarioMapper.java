package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.ComplementarioDto;
import com.folcamp.bancoDeAlimentos.dto.ProductoDto;
import com.folcamp.bancoDeAlimentos.entity.Complementario;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("ComplementarioMapper")
public class ComplementarioMapper {

    public ComplementarioDto entityToDto(Complementario complementario) {
        return Optional
                .ofNullable(complementario)
                .map(
                        ord -> new ComplementarioDto(
                                complementario.getId(),
                                complementario.getDesayuno(),
                                complementario.getAlmuerzoCena(),
                                complementario.getMixto(),
                                complementario.getBolsones(),
                                complementario.getOllaPopular(),
                                complementario.getCopaDeLeche(),
                                complementario.getViandas(),
                                complementario.getMenoresDe3(),
                                complementario.getDe3a12(),
                                complementario.getDe13a17(),
                                complementario.getDe18a70(),
                                complementario.getMasDe71(),
                                complementario.getCentroComunitario(),
                                complementario.getCentroDeJubilados(),
                                complementario.getCentroDeRehabilitacion(),
                                complementario.getCentroDiscapacidad(),
                                complementario.getCentroCultural(),
                                complementario.getClubes(),
                                complementario.getComedores(),
                                complementario.getTotalMujeres(),
                                complementario.getTotal()
                        )
                )
                .orElse(new ComplementarioDto());
    }
}

