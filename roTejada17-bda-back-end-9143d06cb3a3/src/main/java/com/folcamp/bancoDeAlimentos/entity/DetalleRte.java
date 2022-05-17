package com.folcamp.bancoDeAlimentos.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalleRte")
public class DetalleRte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "reporteId", referencedColumnName = "id")
    private Reporte reporte;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    private Producto producto;

    private Double totalKilos;

    @Getter(AccessLevel.NONE)
    @Column(name = "fechaDeVencimiento", columnDefinition = "DATE")
    private String fechaDeVencimiento;

    public String getFechaDeVencimiento(){
        return Optional.ofNullable(fechaDeVencimiento).map(Objects::toString).orElse(null);
    }
}
