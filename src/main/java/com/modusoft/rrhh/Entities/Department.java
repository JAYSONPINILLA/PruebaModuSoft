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
import jakarta.persistence.OneToMany;
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
    @Column(length=4, columnDefinition = "CHAR(4) NOT NULL")
    private String dept_no;

    /**
     * Nombre del departamento: dept_name.
     */      
    @Column(length=40, columnDefinition = "VARCHAR(40) NOT NULL")
    private String dept_name;

    /**
     * Relación Muchos a Muchos con "dept_manager".
     */
    @OneToMany(mappedBy = "department")
    private List<DeptManager> deptManagerEntries;    

    /**
     * Relación Muchos a Muchos con "dept_emp".
     */
    @OneToMany(mappedBy = "department")
    private List<DeptEmp> deptEmpEntries;    
}