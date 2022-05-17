package com.folcamp.bancoDeAlimentos.mappers;


import com.folcamp.bancoDeAlimentos.dto.OrganizacionDto;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import com.folcamp.bancoDeAlimentos.entity.Personales;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class OrganizacionMapper {

    public OrganizacionDto entityToDto(Organizacion organizacion) {
        return Optional
                .ofNullable(organizacion)
                .map(
                        ord -> new OrganizacionDto(
                                organizacion.getId(),
                                organizacion.getName(),
                                organizacion.getNumeroIdentificador(),
                                organizacion.getStreetAddress(),
                                organizacion.getNumberAddress(),
                                organizacion.getBarrioAddress(),
                                organizacion.getDeptoAddress()
                                //organizacion.getPersonales().stream().map(personalesMapper::mapEntityToDto).collect(Collectors.toList())
                                //me pide que lo agregye a organizacion pero deberia estar?


                        )
                ).orElse(new OrganizacionDto());

    }



    public Organizacion mapDtoToEntity(OrganizacionDto organizacionDto) {
        Organizacion organizacion = new Organizacion();
        organizacion.setName(organizacionDto.getName());
        organizacion.setNumeroIdentificador(organizacionDto.getNumeroIdentificador());
        organizacion.setStreetAddress(organizacionDto.getStreetAddress());
        organizacion.setNumberAddress(organizacionDto.getNumberAddress());
        organizacion.setBarrioAddress(organizacionDto.getBarrioAddress());
        organizacion.setDeptoAddress(organizacionDto.getDeptoAddress());

        return organizacion;
    }
}
