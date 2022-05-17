package com.folcamp.bancoDeAlimentos.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;


@Entity
@Table(name="organizacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizacion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    @NotNull
    @Column(name = "numeroIdentificador", columnDefinition = "INT(10) UNSIGNED")
    private Long numeroIdentificador;

    @NotNull
    @Column(name = "calle")
    private String streetAddress;

    @NotNull
    @Column(name = "numeroCalle", columnDefinition = "INT(10) UNSIGNED")
    private String numberAddress;

    @NotNull
    @Column(name = "barrio")
    private String barrioAddress;

    @NotNull
    @Column(name = "departamento")
    private String deptoAddress;


    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    List<Personales>  personales= new ArrayList<>();



}
