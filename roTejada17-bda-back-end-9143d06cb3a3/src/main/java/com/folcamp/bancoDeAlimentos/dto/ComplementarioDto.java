package com.folcamp.bancoDeAlimentos.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplementarioDto {
    private Integer id;
    private Boolean desayuno;
    private Boolean almuerzoCena;
    private Boolean mixto;
    private Boolean bolsones;
    private Boolean ollaPopular;
    private Boolean copaDeLeche;
    private Boolean viandas;
    private Integer menoresDe3;
    private Integer de3a12;
    private Integer de13a17;
    private Integer de18a70;
    private Integer masDe71;
    private Boolean centroComunitario;

    private Boolean centroDeJubilados;

    private Boolean centroDeRehabilitacion;

    private Boolean centroDiscapacidad;

    private Boolean centroCultural;

    private Boolean clubes;

    private Boolean comedores;
    private Integer totalMujeres;
    private Integer total;
}
