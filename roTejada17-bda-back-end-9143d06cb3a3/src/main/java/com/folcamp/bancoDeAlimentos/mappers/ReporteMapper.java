package com.folcamp.bancoDeAlimentos.mappers;

import com.folcamp.bancoDeAlimentos.dto.ReporteDto;
import com.folcamp.bancoDeAlimentos.entity.Reporte;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("reporteMapper")
public class ReporteMapper {

    public ReporteDto entityToDto(Reporte reporte){
        return Optional
                .ofNullable(reporte)
                .map(
                        ord -> new ReporteDto(
                                reporte.getId(),
                                reporte.getNroRemito(),
                                reporte.getPuntoDestino(),
                                reporte.getFechaIngreso(),
                                reporte.getKilos(),
                                reporte.getOrigenDonacion()
                        )
                )
                .orElse(new ReporteDto());
    }
}
