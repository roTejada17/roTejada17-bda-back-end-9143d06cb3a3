package com.folcamp.bancoDeAlimentos.dto;

import com.folcamp.bancoDeAlimentos.entity.Donante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecomisoDto {
    private Integer id;
    private String nroRemito;
    private String fechaDeIngreso;
    private Donante donante;
    private String descripcion;
}
