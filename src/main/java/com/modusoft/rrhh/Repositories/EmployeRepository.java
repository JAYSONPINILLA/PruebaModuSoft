package com.modusoft.rrhh.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.modusoft.rrhh.Entities.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    @Query(value="""
        Select d.dept_name as nameDept, e.emp_no, CONCAT(e.first_name, ' ', e.last_name) as nameEmp, de.from_date, de.to_date, t.title, s.salary 
        From dept_emp de Join departments d On de.dept_no=d.dept_no 
        Join employees e On de.emp_no=e.emp_no 
        Join titles t On e.emp_no=t.emp_no and de.from_date = t.from_date and de.to_date=t.to_date
        Join salaries s On e.emp_no=s.emp_no and de.from_date = s.from_date and de.to_date=s.to_date
        Where de.dept_no = :dept_no
    """, nativeQuery = true)
    public List<Object[]> findByDeptId(@Param("dept_no") String dept_no);

    @Query(value="""
        Select e.first_name, e.last_name, '' as email, t.title, s.salary, 0 as comision, 
               CONCAT(e2.first_name, ' ', e2.last_name) as nameBoss
        From dept_emp de Join departments d On de.dept_no=d.dept_no 
        Join employees e On de.emp_no=e.emp_no 
        Join dept_manager dm On dm.emp_no = de.emp_no and dm.dept_no=de.dept_no 
        Join employees e2 On e2.emp_no=dm.emp_no 
        Join titles t On e.emp_no=t.emp_no and de.from_date = t.from_date and de.to_date=t.to_date
        Join salaries s On e.emp_no=s.emp_no and de.from_date = s.from_date and de.to_date=s.to_date
        Where t.title LIKE CONCAT('%', :title, '%') and dm.emp_no = :idBoss
    """, nativeQuery = true)
    public List<Object[]> findByTitleBoss(@Param("title") String title, @Param("idBoss") Integer idBoss);
    
}
