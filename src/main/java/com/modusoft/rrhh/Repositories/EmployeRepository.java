package com.modusoft.rrhh.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modusoft.rrhh.Entities.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query(value="Select d.name as nameDept, e.emp_no, CONCAT(e.first_name, ' ', e.last_name) as name, de.from_date, de.to_date From dept_emp de Join department d On de.dept_no=d.dept_no Where dept_no = :dept_no", nativeQuery = true)
    public List<Object[]> findByDeptId(@Param("dept_no") String dept_no);

}
