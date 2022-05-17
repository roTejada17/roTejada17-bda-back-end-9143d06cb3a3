package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.CategoriaDto;
import com.folcamp.bancoDeAlimentos.entity.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria mapDTOToEntity (CategoriaDto categoriaDto){

        Categoria categoria = new Categoria();

        categoria.setId(categoriaDto.getId());

        categoria.setName(categoriaDto.getName());

        return categoria;
    }
}

