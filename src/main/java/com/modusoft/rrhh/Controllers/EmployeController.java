/**
 * Controlador de Employees.
 *
 * @author Jayson Pinilla
 * @throws Exception Las excepciones se manejan con package Exception
 */

package com.modusoft.rrhh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modusoft.rrhh.DTOs.DepartmentEmployeDTO;
import com.modusoft.rrhh.DTOs.EmployeDTO;
import com.modusoft.rrhh.DTOs.dataEmployeDTO;
import com.modusoft.rrhh.Services.EmployeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/employee")
@Tag(name="Employee")
public class EmployeController {

    @Autowired
    EmployeService employeservice;
    
    /**
     * Obtiene todos los Employees disponibles.
     *
     * @return Obtiene todos los registros de la tabla Employees
     */    
    @GetMapping
    @Operation(summary = "Obtiene todos los registros de la tabla Employees")
    public ResponseEntity<List<EmployeDTO>> findAll(){
        return ResponseEntity.ok(employeservice.findAll());
    }

    /**
     * Obtiene todos los Employees Por ID de departamento.
     *
     * @return Obtiene todos los registros de la tabla Employees por ID de Departamento
     */    
    
    @GetMapping("/dept/{id}")
    @Operation(summary = "Obtiene todos los registros de la tabla Employees por Departamento")
    public ResponseEntity<List<DepartmentEmployeDTO>> findByDeptId(@PathVariable String id){
        return ResponseEntity.ok(employeservice.findByDeptId(id));
    }

    /**
     * Obtiene todos los Employees por Nombre de Cargo y ID de Jefe.
     *
     * @return Obtiene todos los registros de la tabla Employees por Por Nombre de Cargo y ID de Jefe
     */    
    
    @GetMapping("/titleboss/{title}/{idBoss}")
    @Operation(summary = "Obtiene Employees por Nombre de Cargo y ID de Jefe")
    public ResponseEntity<List<dataEmployeDTO>> findByTitleBoss(@PathVariable String title, @PathVariable Integer idBoss){
        return ResponseEntity.ok(employeservice.findByTitleBoss(title, idBoss));
    }

    /**
     * Obtiene un Employee por id.
     *
     * @param id Datos del employee a buscar
     * @return Obtiene un Employee por id.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un Employees por emp_no")
    public ResponseEntity<EmployeDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(employeservice.findById(id), HttpStatus.OK);
    }

    /**
     * Crea un nuevo employee en la base de datos.
     *
     * @param employeDTO Datos del producto a crear
     * @return Employee creado
     */
    @PostMapping
    @Operation(summary = "Crea un nuevo Employee")
    public ResponseEntity<EmployeDTO> create(EmployeDTO employeDTO){
        return new ResponseEntity<>(employeservice.create(employeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        employeservice.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    
}
