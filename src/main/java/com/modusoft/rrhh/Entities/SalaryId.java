/**
 * Esta clase representa Clave compuesta de tabla Salary.
 * Clave primaria compuesta: (emp_no INT, from_date DATE, to_date DATE).
 *
 * @author Jayson Pinilla
 */

package com.modusoft.rrhh.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class SalaryId implements Serializable {
    private Integer emp_no;
    private LocalDate from_date;
    private LocalDate to_date;

    /**
     * Se sobreescribe el método "equals", usando los tres campos para la comparación.
     */
    @Override
    public boolean equals(Object ob){
         if(this==ob) return true;
         if(!(ob instanceof SalaryId)) return false;
         SalaryId that = (SalaryId) ob;
         return Objects.equals(emp_no, that.emp_no) && 
                Objects.equals(from_date, that.from_date) &&
                Objects.equals(from_date, that.to_date);
    }

    /**
     * Se sobreescribe el método "hashCode", usando los tres campos para la identificación.
     */
    @Override
    public int hashCode(){
            return Objects.hash(emp_no, from_date, to_date);
    }
}
