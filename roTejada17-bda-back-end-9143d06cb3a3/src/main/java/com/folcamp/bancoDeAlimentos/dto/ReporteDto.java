package com.folcamp.bancoDeAlimentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteDto {

    private Integer id;

    private String nroRemito;

    private String puntoDestino;

    private String fechaIngreso;

    private Double kilos;

    private Integer origenDonacion;
}
