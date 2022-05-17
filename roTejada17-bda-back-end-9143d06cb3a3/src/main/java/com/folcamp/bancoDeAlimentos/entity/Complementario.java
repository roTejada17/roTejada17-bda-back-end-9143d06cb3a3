package com.folcamp.bancoDeAlimentos.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "organizacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complementario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "desayuno")
    private Boolean desayuno;
    @NotNull
    @Column(name = "almuerzoCena")
    private Boolean almuerzoCena;
    @NotNull
    @Column(name = "Mixto")
    private Boolean mixto;
    @NotNull
    @Column(name = "Bolsones")
    private Boolean bolsones;
    @NotNull
    @Column(name = "ollaPopular")
    private Boolean ollaPopular;
    @NotNull
    @Column(name = "copaDeLeche")
    private Boolean copaDeLeche;
    @NotNull
    @Column(name = "viandas")
    private Boolean viandas;
    @NotNull
    private Integer menoresDe3;

    @NotNull
    private Integer de3a12;
    @NotNull
    private Integer de13a17;
    @NotNull
    private Integer de18a70;
    @NotNull
    private Integer masDe71;
    @NotNull
    private Boolean centroComunitario;
    @NotNull
    private Boolean centroDeJubilados;
    @NotNull
    private Boolean centroDeRehabilitacion;
    @NotNull
    private Boolean centroDiscapacidad;
    @NotNull
    private Boolean centroCultural;
    @NotNull
    private Boolean clubes;
    @NotNull
    private Boolean comedores;
    private Integer totalMujeres;
    private Integer total;
}

