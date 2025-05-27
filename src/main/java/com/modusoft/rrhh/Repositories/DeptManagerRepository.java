package com.modusoft.rrhh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modusoft.rrhh.Entities.DeptEmpId;
import com.modusoft.rrhh.Entities.DeptManager;

public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptEmpId> {

}
