package com.modusoft.rrhh.DTOs;

import java.time.LocalDate;

public interface IDeptEmpTitleSalaryDTO {
    Integer getEmpNo();
    String getNameEmployee();
    LocalDate getFromDate();
    String getNameDepartment();
    String getNameTitle();
    Integer getSalary();
    LocalDate getToDate();
}
