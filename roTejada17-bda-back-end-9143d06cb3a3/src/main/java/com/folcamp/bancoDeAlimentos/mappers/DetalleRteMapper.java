package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.DetalleRteDto;
import com.folcamp.bancoDeAlimentos.entity.DetalleRte;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("detalleRteMapper")
public class DetalleRteMapper {

    private final ReporteMapper reporteMapper;

    public DetalleRteMapper(ReporteMapper reporteMapper){
        this.reporteMapper = reporteMapper;
    }

    public DetalleRteDto entityToDto(DetalleRte detalleRte){
        return Optional
                .ofNullable(detalleRte)
                .map(
                        ord -> new DetalleRteDto(
                                detalleRte.getId(),
                                detalleRte.getProducto(),
                                detalleRte.getTotalKilos(),
                                detalleRte.getFechaDeVencimiento())
                )
                .orElse(new DetalleRteDto());
    }
}
