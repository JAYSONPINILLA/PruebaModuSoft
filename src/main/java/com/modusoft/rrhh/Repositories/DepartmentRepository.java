package com.modusoft.rrhh.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.modusoft.rrhh.Entities.Department;

public interface DepartmentRepository  extends JpaRepository<Department, String>{
    @Query(value="""
        Select d.dept_name as nameDept, e.emp_no, CONCAT(e.first_name, ' ', e.last_name) as nameEmp, de.from_date, de.to_date, t.title, s.salary 
        From dept_emp de Join departments d On de.dept_no=d.dept_no 
        Join employees e On de.emp_no=e.emp_no 
        Join titles t On e.emp_no=t.emp_no and de.from_date = t.from_date and de.to_date=t.to_date
        Join salaries s On e.emp_no=s.emp_no and de.from_date = s.from_date and de.to_date=s.to_date
        Where de.dept_no = :dept_no
    """, nativeQuery = true)
    public List<Object[]> findManagerByDeptId(@Param("dept_no") String dept_no);
}
