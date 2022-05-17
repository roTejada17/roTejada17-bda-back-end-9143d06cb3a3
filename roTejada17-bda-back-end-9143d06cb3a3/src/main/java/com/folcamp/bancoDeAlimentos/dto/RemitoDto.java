package com.folcamp.bancoDeAlimentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemitoDto {

    private Integer id;

    private String nroRemito;
    
    private String fecha;

    private String personales;

    private String departamento;

    private String organizacion;

}