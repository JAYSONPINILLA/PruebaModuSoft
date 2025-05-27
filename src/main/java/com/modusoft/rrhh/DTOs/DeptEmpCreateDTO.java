package com.modusoft.rrhh.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmpCreateDTO {
    private String dept_no;
    private String dept_name; 
    private Integer emp_no;   
}

