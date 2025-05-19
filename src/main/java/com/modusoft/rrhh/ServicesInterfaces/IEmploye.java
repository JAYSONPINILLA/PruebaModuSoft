package com.modusoft.rrhh.ServicesInterfaces;

import java.util.List;

import com.modusoft.rrhh.DTOs.EmployeDTO;

public interface IEmploye {

    public List<EmployeDTO> findAll();
    public EmployeDTO findById(Integer id);
    public EmployeDTO create(EmployeDTO dto);
    public EmployeDTO update(Integer id, EmployeDTO dto);
    public void deleteById(Integer id);
}
