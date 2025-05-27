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
public class DepartmentEmployeDTO {
    private Integer emp_no;
    private String nameEmp;
    private LocalDate from_date;
    private String nameDept;
    private String nameCargo;
    private Integer salary;
    private LocalDate to_date;
}
