package com.folcamp.bancoDeAlimentos.dto;

import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import com.folcamp.bancoDeAlimentos.entity.Personales;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizacionDto {

    private Integer id;
    private String name;
    private Long numeroIdentificador;
    private String streetAddress;
    private String numberAddress;
    private String barrioAddress;
    private String deptoAddress;


}


