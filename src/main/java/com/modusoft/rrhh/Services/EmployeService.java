package com.modusoft.rrhh.Services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modusoft.rrhh.DTOs.DepartmentEmployeDTO;
import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.DTOs.IDeptEmpTitleSalaryDTO;
import com.modusoft.rrhh.DTOs.dataEmployeDTO;
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
        /*
        List<DepartmentEmployeDTO> listaDTO = new ArrayList<>();
        System.out.println("********** Before execute Query for return Employees By IdDept **********");
        List<Object[]> lista = repoEmployee.findByDeptId(id);
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
            String title = (String) row[5];
            Integer salary = (Integer) row[6];

            conta++;
            System.out.println("********************************************");
            System.out.println("********** Contador: " + conta);
            System.out.println("********** nameDept: " + nameDept + " **********");
            System.out.println("********** Emp_No: " + emp_no + " **********");
            System.out.println("********** Name: " + nameEmp + " **********");
            System.out.println("********** Title: " + title + " **********");
            System.out.println("********** Salary: " + salary + " **********");
            System.out.println("********************************************");
            dto.setNameDept(nameDept);
            dto.setEmp_no(emp_no);
            dto.setNameEmp(nameEmp);
            dto.setFrom_date(fromDate);
            dto.setTo_date(toDate);
            dto.setNameCargo(title);
            dto.setSalary(salary);

            listaDTO.add(dto);
        }
        return listaDTO;
        */
    }

    @Override
    public List<dataEmployeDTO> findByTitleBoss(String title, Integer idBoss) {
        List<dataEmployeDTO> listaDTO = new ArrayList<>();
        System.out.println("********** Before findByTitleBoss **********");
        List<Object[]> lista = repoEmployee.findByTitleBoss(title, idBoss);
        System.out.println("********** After execute Query findByTitleBoss **********");
        int conta=0;
        for(Object[] row : lista){
            dataEmployeDTO dto = new dataEmployeDTO();

            String name = (String) row[0];
            String lastname = (String) row[1];
            String email = (String) row[2];
            String nameTitle = (String) row[3];
            Integer salary = (Integer) row[4];
            Double comision = 0.00;
            String nameBoss  = (String) row[6];

            conta++;
            System.out.println("********************************************");
            System.out.println("********** Contador: " + conta);
            System.out.println("********** nameTitle: " + nameTitle + " **********");
            System.out.println("********** name: " + name + " **********");
            System.out.println("********** Salary: " + salary + " **********");
            System.out.println("********************************************");
                      
            dto.setName(name);
            dto.setLastname(lastname);
            dto.setEmail(email);;
            dto.setNameTitle(nameTitle);
            dto.setSalary(salary);
            dto.setComision(comision);
            dto.setNameBoss(nameBoss);

            listaDTO.add(dto);
        }
        return listaDTO;
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
