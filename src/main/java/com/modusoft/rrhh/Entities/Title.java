package com.modusoft.rrhh.Entities;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name="titles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    @Id
    private Integer emp_no;

    private LocalDateTime from_date;

    private LocalDateTime to_date;
}
