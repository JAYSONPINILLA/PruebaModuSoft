package com.modusoft.rrhh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modusoft.rrhh.Entities.Department;

public interface DepartmentRepository  extends JpaRepository<Department, String>{

}
