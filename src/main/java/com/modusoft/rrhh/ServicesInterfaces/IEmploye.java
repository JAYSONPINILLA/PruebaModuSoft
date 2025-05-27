package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpManagerDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpTitleSalaryDTO;

public interface IEmploye {

    public List<EmployeDTO> findAll();
    public EmployeDTO findById(Integer id);
    public List<IDeptEmpTitleSalaryDTO> findByDeptId(String id);
    public List<IDeptEmpManagerDTO> findByTitleBoss(String title, Integer idBoss);
    public EmployeDTO create(EmployeDTO dto);
    public EmployeDTO update(Integer id, EmployeDTO dto);
    public void deleteById(Integer id);
}
