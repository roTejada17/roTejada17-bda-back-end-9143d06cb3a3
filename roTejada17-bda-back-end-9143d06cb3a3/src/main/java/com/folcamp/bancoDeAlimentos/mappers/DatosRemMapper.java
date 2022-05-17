package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.DatosRemDto;
import com.folcamp.bancoDeAlimentos.entity.DatosRem;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("datosRemMapper")
public class DatosRemMapper {

    private final RemitoMapper remitoMapper;


    public DatosRemMapper(RemitoMapper remitoMapper) {
        this.remitoMapper = remitoMapper;
    }

    public DatosRemDto entityToDto(DatosRem datosRem){
        return Optional
                .ofNullable(datosRem)
                .map(
                        ord ->new DatosRemDto(
                                datosRem.getId(),
                                datosRem.getRemito(),
                                datosRem.getProducto(),
                                datosRem.getFechaDeVencimiento(),
                                datosRem.getKilosDonados()
                        ) )
                                .orElse(new DatosRemDto());
    }
}
