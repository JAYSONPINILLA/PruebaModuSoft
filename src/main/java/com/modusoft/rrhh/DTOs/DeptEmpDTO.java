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
public class DeptEmpDTO {
    private Integer emp_no;
    private String emp_name;
    private String dept_no;
    private String dept_name;
    private LocalDate from_date;
    private LocalDate to_date;
    
}
