package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.DepartmentEmployeDTO;
import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpTitleSalaryDTO;
import com.modusoft.rrhh.DTOs.dataEmployeDTO;

public interface IEmploye {

    public List<EmployeDTO> findAll();
    public EmployeDTO findById(Integer id);
    public List<IDeptEmpTitleSalaryDTO> findByDeptId(String id);
    public List<dataEmployeDTO> findByTitleBoss(String title, Integer idBoss);
    public EmployeDTO create(EmployeDTO dto);
    public EmployeDTO update(Integer id, EmployeDTO dto);
    public void deleteById(Integer id);
}
