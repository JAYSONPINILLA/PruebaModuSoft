/**
 * Esta clase representa un empleado dentro del sistema.
 * Clave primaria: emp_no INT.
 *
 * @author Jayson Pinilla
 * @see EmployeeService
 */

package com.modusoft.rrhh.Entities;

import java.time.LocalDate;
import java.util.List;

import com.modusoft.rrhh.ENUMS.Genero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
@Table(name="employees")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employe {
    /**
     * Identificador único del empleado: dept_no INT.
     */
    @Id
    private Integer emp_no;

    /**
     * Fecha de cumpleaños del empleado.
     */
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate birth_date;

    /**
     * Nombre del empleado, VARCHAR(14).
     */
    @Column(length=14)
    private String first_name;

    /**
     * Apellido del empleado, VARCHAR(16).
     */
    @Column(length=16)
    private String last_name;
    
    /**
     * Sexo del empleado, ENUM('M', 'F').
     * Se crea un ENUM en ./ENUMS/Genero
     */
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Genero sex;

    /**
     * Fecha de Contratación del empleado.
     */
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate hire_date;

    /**
     * Email del empleado, VARCHAR(150).
     */
    @Column(length=150)
    private String email;

    /**
     * Comision del empleado, double.
     */
    @Column
    private Double comision;

    /**
     * Relacion Muchos a Muchos con tabla "dept_manager".
     */
    @OneToMany(mappedBy = "employee")
    private List<DeptManager> deptManagerEntries;    

    /**
     * Relacion Muchos a Muchos con tabla "dept_emp".
     */
    @OneToMany(mappedBy = "employee")
    private List<DeptEmp> deptEmpEntries;     
}
