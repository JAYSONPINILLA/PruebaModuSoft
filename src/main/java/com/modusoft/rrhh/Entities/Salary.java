/**
 * Esta clase representa el salario de un empleado.
 * Clave primaria compuesta por tres campos: @EmbeddedId SalaryId id = (emp_no INT, from_date DATE, to_date DATE).
 * 
 * @author Jayson Pinilla
 * @see SalaryService
 */

package com.modusoft.rrhh.Entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="salaries")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    /**
     * Identificador único del salario: (empno INT, from_date DATE, to_date DATE).
     */
    @EmbeddedId
    private SalaryId id;

    /**
     * Campo Salario.
     */
    @Column
    private Integer salary;

    /**
     * Relacion con tabla "employees" a través del campo "emp_no".
     * MapsId("emp_no") hace referencia al campo en el Embeddable "SalaryId"
     */
    @ManyToOne
    @MapsId("emp_no")
    @JoinColumn(name = "emp_no")
    private Employe employe;   
}
