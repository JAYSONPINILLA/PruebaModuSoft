package com.modusoft.rrhh.DTOs;

import java.time.LocalDate;

import com.modusoft.rrhh.ENUMS.Genero;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
    
    private Integer emp_no;

    private LocalDate birth_date;

    private String first_name;

    private String last_name;
    
    @Enumerated(EnumType.STRING)
    private Genero sex;

    private LocalDate hire_date;
}
