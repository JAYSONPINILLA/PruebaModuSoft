package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.DepartmentDTO;

public interface IDepartment {
    public List<DepartmentDTO> findAll();
    public DepartmentDTO findById(Integer id);
    public DepartmentDTO create(DepartmentDTO dto);
    public DepartmentDTO update(Integer id, DepartmentDTO dto);
    public void deleteById(Integer id);
}
