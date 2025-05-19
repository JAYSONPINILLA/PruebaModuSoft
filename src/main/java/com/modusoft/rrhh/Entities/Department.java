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
    @Id
    @Column(length=4)
    private String dept_no;

    @Column(length=40)
    private String dept_name;

    @ManyToMany(mappedBy="deptManager")
    private List<Employe> employeesManager;

    @ManyToMany(mappedBy="deptEmp")
    private List<Employe> employeesEmp;
}