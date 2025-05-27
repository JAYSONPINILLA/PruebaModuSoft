package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.DepartmentDTO;
import com.modusoft.rrhh.DTOs.DeptEmpCreateDTO;
import com.modusoft.rrhh.DTOs.DeptEmpDTO;

public interface IDepartment {
    public List<DepartmentDTO> findAll();
    public DepartmentDTO findById(String id);
    public DepartmentDTO create(DepartmentDTO dto);
    public DeptEmpDTO createWithManager(DeptEmpCreateDTO dto);
    public DepartmentDTO update(String id, DepartmentDTO dto);
    public void deleteById(String id);
}
