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
@Table(name = "datos")
public class DatosRem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "remitoId", referencedColumnName = "id")
    private Remito remito;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    private Producto producto;

    @Getter(AccessLevel.NONE)
    @Column(name = "fechaDeVencimiento", columnDefinition = "DATE")
    private String fechaDeVencimiento;

    private Double kilosDonados;

    public String getFechaDeVencimiento(){
        return Optional.ofNullable(fechaDeVencimiento).map(Objects::toString).orElse(null);
    }
}