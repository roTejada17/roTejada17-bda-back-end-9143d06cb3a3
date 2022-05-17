package com.folcamp.bancoDeAlimentos.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name="personales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "nombreYApellido", columnDefinition = "TEXT")
    private String name;

    @NotNull
    @Column(name = "numeroFijo", columnDefinition = "INT(10) UNSIGNED")
    private String numberTel;

    @NotNull
    @Column(name = "numeroCelular", columnDefinition = "INT(10) UNSIGNED")
    private String numberCell;

    @Column(name = "numeroCelularAlt", columnDefinition = "INT(10) UNSIGNED")
    private String numberCellAlt;

    @NotNull
    @Column(name="email" ,unique = true)
    private String email;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "organizacionId", referencedColumnName = "id", nullable = false)
    private Organizacion organizacion;
}
