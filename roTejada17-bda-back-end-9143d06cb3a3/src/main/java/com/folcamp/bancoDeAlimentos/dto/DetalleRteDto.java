package com.folcamp.bancoDeAlimentos.dto;

import com.folcamp.bancoDeAlimentos.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleRteDto {

    private Integer id;

    private Producto producto;

    private Double totalKilos;

    private String fechaDeVencimiento;
}
