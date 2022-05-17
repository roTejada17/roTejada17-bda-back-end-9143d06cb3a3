package com.folcamp.bancoDeAlimentos.dto;


import com.folcamp.bancoDeAlimentos.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private Integer id;

    private String name;

    private Boolean perecedero;

    private Integer valorNutricional;

    private Categoria categoria;

}
