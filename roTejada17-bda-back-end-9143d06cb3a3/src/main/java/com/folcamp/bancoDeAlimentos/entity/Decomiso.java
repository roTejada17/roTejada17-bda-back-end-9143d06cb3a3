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
@Table(name = "decomiso")
public class Decomiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nroRemito;

    @Getter(AccessLevel.NONE)
    @Column(name = "fechaDeIngreso", columnDefinition = "DATE")
    private  String fechaDeIngreso;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "donanteId", referencedColumnName = "id")
    private Donante donante;

    private String descripcion;

    public String getFechaDeIngreso(){return Optional.ofNullable(fechaDeIngreso).map(Objects::toString).orElse(null);
    }
}
