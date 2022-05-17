package com.folcamp.bancoDeAlimentos.dto;

public class NewDonanteDto {

    private Long id;
    private String cc;
    private String name;
    private String phoneNumber;
    private String address;

    public NewDonanteDto() {
    }

    public NewDonanteDto(Long id, String cc, String name, String phoneNumber, String address) {
        this.id = id;
        this.cc = cc;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
