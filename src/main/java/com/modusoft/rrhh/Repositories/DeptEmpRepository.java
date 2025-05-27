package com.modusoft.rrhh.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.modusoft.rrhh.DTOs.IDeptEmpTitleSalaryDTO;
import com.modusoft.rrhh.Entities.DeptEmp;
import com.modusoft.rrhh.Entities.DeptEmpId;

public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {
    //FROM DeptEmp de
    //JOIN de.employee e
    //JOIN de.department d
    //JOIN Title t ON (t.employe = e And t.to_date IS NULL)
    //JOIN Salary s ON (s.employe = e And s.id.to_date IS NULL)
    //WHERE de.to_date IS NULL AND d.dept_no = :dept_no
    //""")

    @Query("""
    SELECT 
        e.emp_no as empNo,
        CONCAT(e.first_name, ' ', e.last_name) as nameEmployee,
        de.from_date as fromDate,
        d.dept_name as departmentName,
        t.id.title as nameTitle,
        s.salary as salary,
        de.to_date as toDate
    FROM DeptEmp de
    JOIN de.employee e
    JOIN de.department d
    JOIN Title t ON (t.employe = e And t.to_date = de.to_date And t.from_date = de.from_date)
    JOIN Salary s ON (s.employe = e And s.id.to_date = de.to_date And s.id.from_date = de.from_date)
    WHERE de.to_date IS NULL AND d.dept_no = :dept_no
    """)
    List<IDeptEmpTitleSalaryDTO> findEmployeesByDeptId(@Param("dept_no") String dept_no);

    /*
        @Query("""
        SELECT 
            e.id AS empNo,
            e.firstName AS employeeName,
            m.firstName AS managerName
        FROM DeptEmp de
        JOIN de.employee e
        JOIN de.department d
        JOIN DeptManager dm ON dm.department = d AND dm.toDate IS NULL
        JOIN Employee m ON dm.employee = m
        WHERE de.toDate IS NULL AND d.deptNo = :deptNo
        """)
        List<ActiveEmployeeWithManagerDTO> findActiveEmployeesWithManagerByDepartment(@Param("deptNo") String deptNo);
     */
}
