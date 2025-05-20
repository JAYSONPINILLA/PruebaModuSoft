/**
 * Esta clase representa un empleado dentro del sistema.
 * Clave primaria compuesta por dos campos: @EmbeddedId TitleId id = (empno INT, title VARCHAR(50)).
 *
 * @author Jayson Pinilla
 * @see TitleService
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
@Table(name="titles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    /**
     * Identificador único del titulo del cargo: (empno INT, title VARCHAR(50)).
     */
    @EmbeddedId
    private TitleId id;

    /**
     * Relacion con tabla "employees" a través del campo "emp_no".
     * MapsId("emp_no") hace referencia al campo en el Embeddable "TitleId"
     */
    @ManyToOne
    @MapsId("emp_no")
    @JoinColumn(name = "emp_no")
    private Employe employe;   

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
