package com.modusoft.rrhh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DepartmentEmployeDTO;
import com.modusoft.rrhh.Entities.DepartmentEmploye;
import com.modusoft.rrhh.Entities.DepartmentEmployeId;
import com.modusoft.rrhh.Exceptions.ResourceNotFoundException;
import com.modusoft.rrhh.Repositories.DepartmentEmployeRepository;
import com.modusoft.rrhh.ServicesInterfaces.IDepartmentEmploye;

@Service
public class DepartmentEmployeService implements IDepartmentEmploye{

    @Autowired
    DepartmentEmployeRepository repo;

    @Override
    public List<DepartmentEmployeDTO> findAll() {
        return repo.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public DepartmentEmployeDTO findById(DepartmentEmployeId id) {
        return convertToDTO(repo.findById(id).get());
    }

    @Override
    public DepartmentEmployeDTO create(DepartmentEmployeDTO dto) {
        DepartmentEmploye e = convertToDepartmentEmploye(dto);
        return convertToDTO(repo.save(e));
    }

    @Override
    public DepartmentEmployeDTO update(DepartmentEmployeId id, DepartmentEmployeDTO dto) {
        DepartmentEmploye d = repo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Departamento Empleado no encontrado con DEPT_No: " + id));

        return convertToDTO(repo.save(d));
    }

    @Override
    public void deleteById(DepartmentEmployeId id) {
        repo.deleteById(id);
    }

    private DepartmentEmployeDTO convertToDTO(DepartmentEmploye d){
        DepartmentEmployeDTO dto = new DepartmentEmployeDTO();
        dto.setEmp_no(d.getId().getEmp_no());
        dto.setDept_no(d.getId().getDept_no());
        dto.setFrom_date(d.getFrom_date());
        dto.setTo_date(d.getTo_date());
        return dto;
    }

    private DepartmentEmploye convertToDepartmentEmploye(DepartmentEmployeDTO dto){
        DepartmentEmploye d = new DepartmentEmploye();
        DepartmentEmployeId ide = new DepartmentEmployeId(dto.getEmp_no(), dto.getDept_no());
        d.setId(ide);
        d.setFrom_date(dto.getFrom_date());
        d.setTo_date(dto.getTo_date());
        return d;
    }
}
