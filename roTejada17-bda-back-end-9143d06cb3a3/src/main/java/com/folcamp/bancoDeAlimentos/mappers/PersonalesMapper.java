
package com.folcamp.bancoDeAlimentos.mappers;
import com.folcamp.bancoDeAlimentos.dto.PersonalesDto;
import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import com.folcamp.bancoDeAlimentos.entity.Personales;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonalesMapper {
    private final OrganizacionMapper organizacionMapper;

    public PersonalesMapper(OrganizacionMapper organizacionMapper) {
        this.organizacionMapper = organizacionMapper;
    }

    public Personales mapDtoToEntity(PersonalesDto personalesDto, Organizacion organizacion) {
        Personales personales = new Personales();

        personales.setId(personalesDto.getId());
        personales.setName(personalesDto.getFullName());
        personales.setNumberTel(personalesDto.getNumberTel());
        personales.setNumberCell(personalesDto.getNumberCell());
        personales.setOrganizacion(organizacion);//mapper de organizacion
        return personales;

    }

    public PersonalesDto mapEntityToDto(Personales personales) {
        return Optional
                .ofNullable(personales)
                .map(
                        ord -> new PersonalesDto(
                                personales.getId(),
                                personales.getName(),
                                personales.getNumberTel(),
                                personales.getNumberCell(),
                                personales.getNumberCellAlt(),
                                personales.getEmail(),
                                organizacionMapper.entityToDto(personales.getOrganizacion())
                                //  personales.getOrganizacion().stream().map(OrganizacionMapper::mapDtoToEntity)

                                //organizacion.getPersonales().stream().map(personalesMapper::mapEntityToDto).collect(Collectors.toList())
                                //me pide que lo agregye a organizacion pero deberia estar?


                        )
                ).orElse(new PersonalesDto());


    }
}

