package com.folcamp.bancoDeAlimentos.entity;

import com.folcamp.bancoDeAlimentos.enums.RolName;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
/*@Table(name = "rol")*/
public class Rol {
    @Id
    /*@Column(name = "id", columnDefinition = "INT(10) UNSIGNED")*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    /*@Column*/
    private RolName rolName;

    public Rol() {
    }

    public Rol(@NotNull RolName rolName) {
        this.rolName = rolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }
}
