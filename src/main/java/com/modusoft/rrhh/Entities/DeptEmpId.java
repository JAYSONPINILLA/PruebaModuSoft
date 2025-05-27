/**
 * Esta clase representa Clave compuesta de tabla Title.
 * Clave primaria compuesta: (emp_no INT, dept_no CHAR(4)).
 *
 * @author Jayson Pinilla
 */
package com.modusoft.rrhh.Entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class DeptEmpId implements Serializable {
    private Integer emp_no;
    private String dept_no;

    /**
     * Se sobreescribe el método "equals", usando los dos campos para la comparación.
     */
    @Override
    public boolean equals(Object ob){
         if(this==ob) return true;
         if(!(ob instanceof DeptEmpId)) return false;
         DeptEmpId that = (DeptEmpId) ob;
         return Objects.equals(dept_no, that.dept_no) && 
                Objects.equals(emp_no, that.emp_no);
    }

    /**
     * Se sobreescribe el método "hashCode", usando los dos campos para la identificación.
     */
    @Override
    public int hashCode(){
            return Objects.hash(emp_no, dept_no);
    }
}
