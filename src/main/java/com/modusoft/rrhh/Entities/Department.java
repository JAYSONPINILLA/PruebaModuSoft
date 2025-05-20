/**
 * Esta clase representa un empleado dentro del sistema.
 * Clave primaria: dept_no CHAR(4).
 *
 * @author Jayson Pinilla
 * @see DepartmentService
 */

package com.modusoft.rrhh.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="departments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * Identificador único del departamento: dept_no CHAR(4).
     */    
    @Id
    @Column(length=4)
    private String dept_no;

    /**
     * Nombre del departamento: dept_name.
     */      
    @Column(length=40)
    private String dept_name;

    /**
     * Relación Muchos a Muchos con "dept_manager".
     */      
    @ManyToMany(mappedBy="deptManagers")
    private List<Employe> employeesManager;

    /**
     * Relación Muchos a Muchos con "dept_emp".
     */      
    @ManyToMany(mappedBy="deptEmps")
    private List<Employe> employeesEmp;
}