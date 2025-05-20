package com.modusoft.rrhh.Services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DepartmentEmployeDTO;
import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.Entities.Employe;
import com.modusoft.rrhh.Exceptions.ResourceNotFoundException;
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
    public List<DepartmentEmployeDTO> findByDeptId(String id) {
        List<DepartmentEmployeDTO> listaDTO = new ArrayList<>();
        System.out.println("********** Before execute Query for return Employees By IdDept **********");
        List<Object[]> lista = repo.findByDeptId(id);
        System.out.println("********** After execute Query for return Employees By IdDept **********");
        int conta=0;
        for(Object[] row : lista){
            DepartmentEmployeDTO dto = new DepartmentEmployeDTO();
            String nameDept = (String) row[0];
            Integer emp_no = (Integer) row[1];
            String nameEmp = (String) row[2];
            
            Date SQLDate = (java.sql.Date) row[3];
            LocalDate fromDate = SQLDate.toLocalDate();
            
            SQLDate = (java.sql.Date) row[4];
            LocalDate toDate = SQLDate.toLocalDate();

            conta++;
            System.out.println("********************************************");
            System.out.println("********** Contador: " + conta);
            System.out.println("********** Emp_No: " + emp_no + " **********");
            System.out.println("********** Name: " + nameEmp + " **********");
            System.out.println("********************************************");
            dto.setNameDept(nameDept);
            dto.setEmp_no(emp_no);
            dto.setNameEmp(nameEmp);
            dto.setFrom_date(fromDate);
            dto.setTo_date(toDate);

            listaDTO.add(dto);
        }
        return listaDTO;

        
    }

    @Override
    public EmployeDTO create(EmployeDTO dto) {
        Employe e = convertToEmploye(dto);
        return convertToDTO(repo.save(e));
    }

    @Override
    public EmployeDTO update(Integer id, EmployeDTO dto) {
        Employe e = repo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con EMP_No: " + id));

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
