package com.folcamp.bancoDeAlimentos.dto;

import com.folcamp.bancoDeAlimentos.entity.Organizacion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalesDto {
 private Integer id;
 private String fullName;
 private String numberTel;
 private String numberCell;
 private String numberCellAlt;
 private String email;
 private OrganizacionDto organizacion;
}
