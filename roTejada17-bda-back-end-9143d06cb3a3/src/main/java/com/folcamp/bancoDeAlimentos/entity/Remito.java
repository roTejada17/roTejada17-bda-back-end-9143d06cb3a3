package com.folcamp.bancoDeAlimentos.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "remito")
public class Remito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nroRemito;

    @Getter(AccessLevel.NONE)
    @Column(name = "fecha", columnDefinition = "DATE")
    private String fecha;

    private String personales;

    private String departamento;

    private String organizacion;

    public String getFecha(){
        return Optional.ofNullable(fecha).map(Objects::toString).orElse(null);
    }
}