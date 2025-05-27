package com.modusoft.rrhh.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DepartmentDTO;
import com.modusoft.rrhh.DTOs.DeptEmpCreateDTO;
import com.modusoft.rrhh.DTOs.DeptEmpDTO;
import com.modusoft.rrhh.Entities.Department;
import com.modusoft.rrhh.Entities.DeptEmpId;
import com.modusoft.rrhh.Entities.DeptManager;
import com.modusoft.rrhh.Entities.Employe;
import com.modusoft.rrhh.Exceptions.ResourceNotFoundException;
import com.modusoft.rrhh.Repositories.DepartmentRepository;
import com.modusoft.rrhh.Repositories.DeptManagerRepository;
import com.modusoft.rrhh.Repositories.EmployeRepository;
import com.modusoft.rrhh.ServicesInterfaces.IDepartment;

@Service
public class DepartmentService implements IDepartment{

    @Autowired
    DepartmentRepository repoDepartment;

    @Autowired
    EmployeRepository repoEmployee;

    @Autowired
    DeptManagerRepository repoDeptManager;


    @Override
    public List<DepartmentDTO> findAll() {
        return repoDepartment.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public DepartmentDTO findById(String id) {
        return convertToDTO(repoDepartment.findById(id).get());
    }

    @Override
    public DepartmentDTO create(DepartmentDTO dto) {
        Department e = convertToDepartment(dto);
        return convertToDTO(repoDepartment.save(e));
    }

    @Override
    public DeptEmpDTO createWithManager(DeptEmpCreateDTO dto) {
        String dept_name = dto.getDept_name();
        String dept_no = dto.getDept_no();
        Integer emp_no = dto.getEmp_no();

        if(repoDepartment.existsById(dept_no))
            throw new ResourceNotFoundException("No se puede crear: El ID de Departamento con Dept_no = "+dept_no+" YA EXISTE!");

        if(!repoEmployee.existsById(emp_no))
            throw new ResourceNotFoundException("No se puede crear: El ID de Empleado Jefe con emp_no = "+dept_no+" NO EXISTE!");

        Department d = new Department();
        d.setDept_no(dept_no);
        d.setDept_name(dept_name);
        d = repoDepartment.save(d);
        if(!repoDepartment.existsById(dept_no))
            throw new ResourceNotFoundException("No se pudo crear el Departamento con Dept_no = "+dept_no+"!");

        DeptManager dm = new DeptManager();
        DeptEmpId id = new DeptEmpId();
        id.setDept_no(dept_no);
        id.setEmp_no(emp_no);

        dm.setId(id);
        dm.setFrom_date(LocalDate.now());
        dm.setTo_date(LocalDate.of(9999, 01, 01));        
        dm = repoDeptManager.save(dm);

        if(!repoDeptManager.existsById(id))
            throw new ResourceNotFoundException("No se pudo crear el Manager del Departamento con Emp_no = " + emp_no + " y Dept_no = " + dept_no + "!");


        Employe e = repoEmployee.findById(emp_no).get();
        DeptEmpDTO retornar = new DeptEmpDTO();

        retornar.setDept_no(dm.getId().getDept_no());
        retornar.setDept_name(d.getDept_name());
        
        retornar.setEmp_no(dm.getId().getEmp_no());
        retornar.setEmp_name(e.getFirst_name()+' '+e.getLast_name());
        retornar.setFrom_date(dm.getFrom_date());
        retornar.setTo_date(dm.getTo_date());

        return retornar;
    }

    @Override
    public DepartmentDTO update(String id, DepartmentDTO dto) {
        //Department d = repo.findById(id).get();
        Department d = repoDepartment.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Departamento no encontrado con DEPT_No: " + id));

        return convertToDTO(repoDepartment.save(d));
    }

    @Override
    public void deleteById(String id) {
        repoDepartment.deleteById(id);
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
