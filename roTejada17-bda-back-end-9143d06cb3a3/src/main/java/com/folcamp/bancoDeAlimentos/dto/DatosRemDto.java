package com.folcamp.bancoDeAlimentos.dto;

import com.folcamp.bancoDeAlimentos.entity.Producto;
import com.folcamp.bancoDeAlimentos.entity.Remito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosRemDto {

    private Integer id;

    private Remito remito;

    private Producto producto;

    private String fechaDeVencimiento;

    private Double kilosDonados;
}
