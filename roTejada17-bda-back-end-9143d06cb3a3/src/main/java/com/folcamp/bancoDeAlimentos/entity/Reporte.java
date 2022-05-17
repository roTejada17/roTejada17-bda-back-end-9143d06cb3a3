package com.folcamp.bancoDeAlimentos.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reporte")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nroRemito;

    private String puntoDestino = "Banco de Alimentos Sede San juan";

    @Getter(AccessLevel.NONE)
    @Column(name = "fechaDeIngreso", columnDefinition = "DATE")
    private String fechaIngreso;

    private Double kilos;

    private Integer origenDonacion;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "donanteId", referencedColumnName = "id")
    private Donante donante;


    public String getFechaIngreso(){
        return Optional.ofNullable(fechaIngreso).map(Objects::toString).orElse(null);
    }
}