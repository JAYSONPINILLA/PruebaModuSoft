package com.modusoft.rrhh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.Services.EmployeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeController {

    @Autowired
    EmployeService employeservice;
    
    @GetMapping
    public ResponseEntity<List<EmployeDTO>> findAll(){
        return ResponseEntity.ok(employeservice.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeservice.findById(id));
    }
}
