package com.folcamp.bancoDeAlimentos.dto;

public class EditDonanteDto {

    private String cc;
    private String name;
    private String phoneNumber;
    private String address;

    public EditDonanteDto() {
    }

    public EditDonanteDto(String cc, String name, String phoneNumber, String address) {
        this.cc = cc;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getCc() {
        return cc;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
}
