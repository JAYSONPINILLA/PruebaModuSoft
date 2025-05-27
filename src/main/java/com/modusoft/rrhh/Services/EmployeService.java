package com.modusoft.rrhh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpManagerDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpTitleSalaryDTO;
import com.modusoft.rrhh.Entities.Employe;
import com.modusoft.rrhh.Exceptions.ResourceNotFoundException;
import com.modusoft.rrhh.Repositories.DeptEmpRepository;
import com.modusoft.rrhh.Repositories.EmployeRepository;
import com.modusoft.rrhh.ServicesInterfaces.IEmploye;



@Service
public class EmployeService implements IEmploye{

    @Autowired
    EmployeRepository repoEmployee;

    @Autowired
    DeptEmpRepository repoDeptEmp;

    @Override
    public List<EmployeDTO> findAll() {
        return repoEmployee.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public EmployeDTO findById(Integer id) {
        return convertToDTO(repoEmployee.findById(id).get());
    }
    
    @Override
    public List<IDeptEmpTitleSalaryDTO> findByDeptId(String id) {
        System.out.println("********** Before execute Query for return Employees By IdDept **********");
        List<IDeptEmpTitleSalaryDTO> query = repoDeptEmp.findEmployeesByDeptId(id);
        System.out.println("********** After execute Query for return Employees By IdDept **********");
        return query;
    }

    @Override
    public List<IDeptEmpManagerDTO> findByTitleBoss(String title, Integer idBoss) {
        System.out.println("********** Before **********");
        List<IDeptEmpManagerDTO> query = repoDeptEmp.findEmployeesByTitleAndIdBoss(title, idBoss);
        System.out.println("********** After **********");
        return query;
    }

    @Override
    public EmployeDTO create(EmployeDTO dto) {
        Employe e = convertToEmploye(dto);
        return convertToDTO(repoEmployee.save(e));
    }

    @Override
    public EmployeDTO update(Integer id, EmployeDTO dto) {
        Employe e = repoEmployee.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con EMP_No: " + id));

        return convertToDTO(repoEmployee.save(e));
    }

    @Override
    public void deleteById(Integer id) {
        repoEmployee.deleteById(id);
    }

    private EmployeDTO convertToDTO(Employe e){
        EmployeDTO dto = new EmployeDTO();
        dto.setEmp_no(e.getEmp_no());
        dto.setBirth_date(e.getBirth_date());
        dto.setFirst_name(e.getFirst_name());
        dto.setLast_name(e.getLast_name());
        dto.setHire_date(e.getHire_date());
        dto.setSex(e.getSex());
        return dto;
    }

    private Employe convertToEmploye(EmployeDTO dto){
        Employe e = new Employe();
        e.setEmp_no(dto.getEmp_no());
        e.setBirth_date(dto.getBirth_date());
        e.setFirst_name(dto.getFirst_name());
        e.setLast_name(dto.getLast_name());
        e.setHire_date(dto.getHire_date());
        e.setSex(dto.getSex());
        return e;
    }    
}
