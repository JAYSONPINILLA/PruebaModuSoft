package com.modusoft.rrhh.DTOs;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class dataEmployeDTO {
    private String name;
    private String lastname;
    private String email;
    private String nameTitle;
    private Integer salary;
    private Double comision;
    private String nameBoss;
}
