/**
 * Controlador de DepartmentManager.
 *
 * @author Jayson Pinilla
 * @throws Exception Las excepciones se manejan con package Exception
 */

package com.modusoft.rrhh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modusoft.rrhh.DTOs.DeptEmpDTO;
import com.modusoft.rrhh.Services.DeptManagerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/deptmanager")
@Tag(name="DepartmentManager")
public class DeptManagerController {

    @Autowired
    DeptManagerService deptManagerService;
    
    /**
     * Obtiene todos los Manager de Departmentos.
     *
     * @return Obtiene todos los registros de la tabla DeptManager
     */    
    @GetMapping
    @Operation(summary = "Obtiene todos los registros de la tabla DeptManager")
    public ResponseEntity<List<DeptEmpDTO>> findAll(){
        return ResponseEntity.ok(deptManagerService.findAll());
    }

    /**
     * Obtiene un DepartmentManager por Dept_no.
     *
     * @param id Datos del department a buscar (dept_no)
     * @return Obtiene un DepartmentManager por Dept_no.
     */
    @GetMapping("/{dept_no}")
    @Operation(summary = "Obtiene todos los registros de la tabla DeptManager por Dept_no")
    public ResponseEntity<List<DeptEmpDTO>> findByDeptId(@PathVariable String dept_no){
        return ResponseEntity.ok(deptManagerService.findByDeptId(dept_no));
    }

    /**
     * Obtiene un DepartmentManager por Emp_no.
     *
     * @param id Datos del department a buscar (emp_no)
     * @return Obtiene un DepartmentManager por emp_no.
     */
    @GetMapping("/{emp_no}")
    @Operation(summary = "Obtiene todos los registros de la tabla DeptManager por Dept_no")
    public ResponseEntity<List<DeptEmpDTO>> findByDeptId(@PathVariable Integer emp_no){
        return ResponseEntity.ok(deptManagerService.findByEmpId(emp_no));
    }

    /**
     * Crea un nuevo DepartmentManager en la base de datos.
     *
     * @param DeptEmpDTO Datos del producto a crear
     * @return DepartmentManager creado
     */
    /*
    @PostMapping
    @Operation(summary = "Crea un nuevo Manager de Department")
    public ResponseEntity<DeptEmpDTO> create(DeptEmpDTO deptEmpDTO){
        return new ResponseEntity<>(deptManagerService.create(deptEmpDTO), HttpStatus.CREATED);
    }
    */

}

