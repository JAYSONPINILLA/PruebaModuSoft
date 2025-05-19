package com.modusoft.rrhh.Entities;

import java.time.LocalDateTime;
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
    @Id
    private Integer emp_no;

    private LocalDateTime birth_date;

    @Column(length=14)
    private String first_name;

    @Column(length=16)
    private String last_name;
    
    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Genero sex;
    
    private LocalDateTime hire_date;

    @ManyToMany
    @JoinTable(
        name = "dept_manager",
        joinColumns = @JoinColumn(name = "emp_no"),
        inverseJoinColumns = @JoinColumn(name = "dept_no")
    )
    private List<Department> deptManager;
                             
    @ManyToMany
    @JoinTable(
        name = "dept_emp",
        joinColumns = @JoinColumn(name = "emp_no"),
        inverseJoinColumns = @JoinColumn(name = "dept_no")
    )
    private List<Department> deptEmp;
}
