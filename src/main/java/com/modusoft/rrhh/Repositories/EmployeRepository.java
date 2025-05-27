package com.modusoft.rrhh.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.modusoft.rrhh.Entities.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    
}
