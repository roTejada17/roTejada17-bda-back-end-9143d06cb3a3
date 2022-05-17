package com.folcamp.bancoDeAlimentos.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Objects;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "productoId", referencedColumnName = "id")
    private Producto producto;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String fechaDeVencimiento;

    private Double totalKilos;

    public YearMonth getFechaDeVencimiento(){
        return Optional
                .ofNullable(this.fechaDeVencimiento)
                .map(LocalDate::parse)
                .map(YearMonth::from)
                .orElse(YearMonth.now());
    }

    public void setFechaDeVencimiento(YearMonth fecha){
        this.fechaDeVencimiento = Optional.ofNullable(fecha).map(Objects::toString).orElse(null);
    }
}
