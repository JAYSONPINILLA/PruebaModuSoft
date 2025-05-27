/**
 * Esta clase representa un la tabla intermedia que Guarda los Empleados de cada Depto.
 * Clave primaria compuesta por dos campos: @EmbeddedId DeptEmpId id = (emp_no INT, dept_no CHAR(4)).
 *
 * @author Jayson Pinilla
 * @see DeptEmpService
 */
package com.modusoft.rrhh.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="dept_emp")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmp {
    /**
     * Identificador único del DeptManager: (empno INT, depno CHAR(4)).
     */
    @EmbeddedId
    private DeptEmpId id;

    /**
     * Relacion con tabla "employees" a través del campo "emp_no".
     * MapsId("emp_no") hace referencia al campo en el Embeddable "DeptEmpId"
     */
    @ManyToOne
    @MapsId("emp_no")
    @JoinColumn(name = "emp_no")
    private Employe employee;

    /**
     * Relacion con tabla "departments" a través del campo "dep_no".
     * MapsId("dep_no") hace referencia al campo en el Embeddable "DeptEmpId"
     */    
    @ManyToOne
    @MapsId("dept_no")
    @JoinColumn(name = "dept_no")
    private Department department;

    /**
     * Campo desde(fecha).
     */
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate from_date;

    /**
     * Campo hasta(fecha).
     */
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate to_date;
}
