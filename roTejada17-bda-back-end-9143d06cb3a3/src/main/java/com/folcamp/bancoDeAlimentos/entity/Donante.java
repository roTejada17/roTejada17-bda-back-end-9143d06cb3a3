package com.folcamp.bancoDeAlimentos.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "donante")
public class Donante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String cc;
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;

    public Donante() {
    }

    public Donante(String cc, String name, String phoneNumber, String address) {
        this.cc = cc;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
