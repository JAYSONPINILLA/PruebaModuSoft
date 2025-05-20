package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.DepartmentDTO;

public interface IDepartment {
    public List<DepartmentDTO> findAll();
    public DepartmentDTO findById(String id);
    public DepartmentDTO create(DepartmentDTO dto);
    public DepartmentDTO update(String id, DepartmentDTO dto);
    public void deleteById(String id);
}
