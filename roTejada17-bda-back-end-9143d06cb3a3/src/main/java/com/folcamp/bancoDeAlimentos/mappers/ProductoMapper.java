package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.ProductoDto;
import com.folcamp.bancoDeAlimentos.entity.Producto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("productoMapper")
public class ProductoMapper {
    private final CategoriaMapper categoriaMapper;

    public ProductoMapper(CategoriaMapper categoriaMapper){
        this.categoriaMapper = categoriaMapper;
    }

    public ProductoDto entityToDto(Producto producto){
        return Optional
                .ofNullable(producto)
                .map(
                        ord -> new ProductoDto(
                                producto.getId(),
                                producto.getName(),
                                producto.getPerecedero(),
                                producto.getValorNutricional(),
                                producto.getCategoria()
                                )
                )
                .orElse(new ProductoDto());
    }
}
