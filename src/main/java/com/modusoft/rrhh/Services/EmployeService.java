package com.modusoft.rrhh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.ENUMS.Genero;
//import com.modusoft.rrhh.ENUMS.Genero;
import com.modusoft.rrhh.Entities.Employe;
import com.modusoft.rrhh.Repositories.EmployeRepository;
import com.modusoft.rrhh.ServicesInterfaces.IEmploye;

@Service
public class EmployeService implements IEmploye{

    @Autowired
    EmployeRepository repo;

    @Override
    public List<EmployeDTO> findAll() {
        return repo.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public EmployeDTO findById(Integer id) {
        return convertToDTO(repo.findById(id).get());
    }

    @Override
    public EmployeDTO create(EmployeDTO dto) {
        Employe e = convertToEmploye(dto);
        return convertToDTO(repo.save(e));
    }

    @Override
    public EmployeDTO update(Integer id, EmployeDTO dto) {
        Employe e = repo.findById(id).get();

        return convertToDTO(repo.save(e));
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    private EmployeDTO convertToDTO(Employe e){
        EmployeDTO dto = new EmployeDTO();
        dto.setEmp_no(e.getEmp_no());
        dto.setBirth_date(e.getBirth_date());
        dto.setFirst_name(e.getFirst_name());
        dto.setLast_name(e.getLast_name());
        dto.setHire_date(e.getHire_date());
        Genero gen = e.getSex();
        dto.setSex(gen);
        return dto;
    }

    private Employe convertToEmploye(EmployeDTO dto){
        Employe e = new Employe();
        e.setEmp_no(dto.getEmp_no());
        e.setBirth_date(dto.getBirth_date());
        e.setFirst_name(dto.getFirst_name());
        e.setLast_name(dto.getLast_name());
        e.setHire_date(dto.getHire_date());
        Genero gen = dto.getSex();
        e.setSex(gen);
        return e;
    }    
}
