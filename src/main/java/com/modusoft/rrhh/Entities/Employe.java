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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
     * Relacion Muchos a Muchos con tabla "dept_manager".
     */
    @ManyToMany
    @JoinTable(
        name = "dept_manager",
        joinColumns = @JoinColumn(name = "emp_no"),
        inverseJoinColumns = @JoinColumn(name = "dept_no")
    )
    private List<Department> deptManagers;

    /**
     * Relacion Muchos a Muchos con tabla "dept_emp".
     */
    @ManyToMany
    @JoinTable(
        name = "dept_emp",
        joinColumns = @JoinColumn(name = "emp_no"),
        inverseJoinColumns = @JoinColumn(name = "dept_no")
    )
    private List<Department> deptEmps;
}
