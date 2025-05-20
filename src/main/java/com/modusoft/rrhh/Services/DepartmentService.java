package com.modusoft.rrhh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DepartmentDTO;
import com.modusoft.rrhh.Entities.Department;
import com.modusoft.rrhh.Exceptions.ResourceNotFoundException;
import com.modusoft.rrhh.Repositories.DepartmentRepository;
import com.modusoft.rrhh.ServicesInterfaces.IDepartment;

@Service
public class DepartmentService implements IDepartment{

    @Autowired
    DepartmentRepository repo;

    @Override
    public List<DepartmentDTO> findAll() {
        return repo.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public DepartmentDTO findById(String id) {
        return convertToDTO(repo.findById(id).get());
    }

    @Override
    public DepartmentDTO create(DepartmentDTO dto) {
        Department e = convertToDepartment(dto);
        return convertToDTO(repo.save(e));
    }

    @Override
    public DepartmentDTO update(String id, DepartmentDTO dto) {
        //Department d = repo.findById(id).get();
        Department d = repo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Departamento no encontrado con DEPT_No: " + id));

        return convertToDTO(repo.save(d));
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    private DepartmentDTO convertToDTO(Department d){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDept_no(d.getDept_no());
        dto.setDept_name(d.getDept_name());
        return dto;
    }

    private Department convertToDepartment(DepartmentDTO dto){
        Department d = new Department();
        d.setDept_no(dto.getDept_no());
        d.setDept_name(dto.getDept_name());
        return d;
    }    
}
