/**
 * Controlador de DepartmentManager.
 *
 * @author Jayson Pinilla
 * @throws Exception Las excepciones se manejan con package Exception
 */

package com.modusoft.rrhh.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DeptEmpDTO;
import com.modusoft.rrhh.Entities.Department;
import com.modusoft.rrhh.Entities.DeptEmpId;
import com.modusoft.rrhh.Entities.DeptManager;
import com.modusoft.rrhh.Entities.Employe;
import com.modusoft.rrhh.Repositories.DepartmentRepository;
import com.modusoft.rrhh.Repositories.DeptManagerRepository;
import com.modusoft.rrhh.Repositories.EmployeRepository;

@Service
public class DeptManagerService {

    @Autowired
    DeptManagerRepository repoDeptManager;

    @Autowired
    DepartmentRepository repoDepartment;
    
    @Autowired
    EmployeRepository repoEmployee;

    public List<DeptEmpDTO> findAll() {
        return repoDeptManager.findAll().stream().map(this::convertToDTO).toList();
    }

    public List<DeptEmpDTO> findByDeptId(String id) {
        return repoDeptManager.findByDeptId(id).stream().map(this::convertToDTO).toList();
    }

    public List<DeptEmpDTO> findByEmpId(Integer id) {
        return repoDeptManager.findByEmpId(id).stream().map(this::convertToDTO).toList();
    }

    public DeptEmpDTO create(DeptEmpDTO dto) {
        DeptManager e = convertToDepartment(dto);
        return convertToDTO(repoDeptManager.save(e));
    }

    private DeptEmpDTO convertToDTO(DeptManager d){
        DeptEmpDTO dto = new DeptEmpDTO();
        Department dep = repoDepartment.findById(d.getId().getDept_no()).get();
        Employe    emp = repoEmployee.findById(d.getId().getEmp_no()).get();
        
        dto.setDept_no(d.getId().getDept_no());
        dto.setEmp_no(d.getId().getEmp_no());
        dto.setFrom_date(d.getFrom_date());
        dto.setTo_date(d.getTo_date());
        dto.setEmp_name(emp.getFirst_name()+' '+emp.getLast_name());
        dto.setDept_name(dep.getDept_name());

        return dto;
    }

    private DeptManager convertToDepartment(DeptEmpDTO dto){
        DeptManager d = new DeptManager();
        DeptEmpId id = new DeptEmpId();
        id.setEmp_no(dto.getEmp_no());
        id.setDept_no(dto.getDept_no());
        d.setId(id);
        d.setFrom_date(dto.getFrom_date());
        d.setTo_date(dto.getTo_date());

        return d;
    }    
}
