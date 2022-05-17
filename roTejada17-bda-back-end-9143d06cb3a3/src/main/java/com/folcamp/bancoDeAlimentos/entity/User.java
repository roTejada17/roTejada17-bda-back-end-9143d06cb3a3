package com.folcamp.bancoDeAlimentos.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(10) UNSIGNED")
    private Long id;

    @NotNull
    @Column(name = "nombre", columnDefinition = "TEXT")
    private String name;

    @NotNull
    @Column(unique = true, name = "nombreUsuario", columnDefinition = "TEXT")
    private String nameUser;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(name = "password", columnDefinition = "TEXT")
    private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name= "Rol_Id"))
    private Set<Rol> roles = new HashSet<>();

    public User() {
    }
    public User(@NotNull String name, @NotNull String nameUser,@NotNull String email,@NotNull String password) {
        this.name = name;
        this.nameUser = nameUser;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
