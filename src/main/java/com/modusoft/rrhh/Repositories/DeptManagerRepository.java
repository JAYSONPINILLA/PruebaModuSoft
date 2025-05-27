package com.modusoft.rrhh.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.modusoft.rrhh.Entities.DeptEmpId;
import com.modusoft.rrhh.Entities.DeptManager;

public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptEmpId> {
    
    @Query("""
    SELECT dm
    FROM DeptManager dm
    WHERE dm.department.dept_no = :dept_no
    """)
    List<DeptManager> findByDeptId(@Param("dept_no") String dept_no);

    @Query("""
    SELECT dm
    FROM DeptManager dm
    WHERE dm.employee.emp_no = :emp_no
    """)
    List<DeptManager> findByEmpId(@Param("emp_no") Integer emp_no);    
}
