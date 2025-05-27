/**
 * Controlador de Departments.
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

import com.modusoft.rrhh.DTOs.DepartmentDTO;
import com.modusoft.rrhh.DTOs.DeptEmpCreateDTO;
import com.modusoft.rrhh.DTOs.DeptEmpDTO;
import com.modusoft.rrhh.Services.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/department")
@Tag(name="Department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentservice;
    
    /**
     * Obtiene todos los Departmentos disponibles.
     *
     * @return Obtiene todos los registros de la tabla Departmentos
     */    
    @GetMapping
    @Operation(summary = "Obtiene todos los registros de la tabla Departmentos")
    public ResponseEntity<List<DepartmentDTO>> findAll(){
        return ResponseEntity.ok(departmentservice.findAll());
    }

    /**
     * Obtiene un Departmente por id.
     *
     * @param id Datos del departmente a buscar
     * @return Obtiene un Departmente por id.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un Departmento por dept_no")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable String id){
        return new ResponseEntity<>(departmentservice.findById(id), HttpStatus.OK);
    }

    /**
     * Crea un nuevo departmente en la base de datos.
     *
     * @param departmentDTO Datos del producto a crear
     * @return Departmente creado
     */
    @PostMapping
    @Operation(summary = "Crea un nuevo Department")
    public ResponseEntity<DepartmentDTO> create(DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentservice.create(departmentDTO), HttpStatus.CREATED);
    }

    /**
     * Crea un nuevo departmente en la base de datos.
     *
     * @param departmentDTO Datos del producto a crear
     * @return Departmente creado
     */
    @PostMapping("/withManager")
    @Operation(summary = "Crea un nuevo Department con Manager")
    public ResponseEntity<DeptEmpDTO> createWithManager(DeptEmpCreateDTO departmentWithManagerDTO){
        return new ResponseEntity<>(departmentservice.createWithManager(departmentWithManagerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        departmentservice.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    
}
