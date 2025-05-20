package com.modusoft.rrhh.api;
//import com.modusoft.rrhh.Entities.Employe;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeApiTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void crearEmployee_debeRetornar201YDatosCorrectos() {
        String json = """
            {
              "emp_no": 12345,
              "birt_date": 2000-01-01,
              "first_name": "Jorge",
              "last_name": "Perez",
              "hire_date": 2020-06-01,
            }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(json)
        .when()
            .post("/api/employee")
        .then()
            .statusCode(201)
            //.body("id", notNullValue())
            .body("emp_no", equalTo(12345))
            .body("birt_date", equalTo(2000-01-01))
            .body("first_name", equalTo("Jorge"))
            .body("last_name", equalTo("Perez"))
            .body("hire_date", equalTo(2020-06-01));
    }

    @Test
    void listarEmployees_debeRetornar200() {
        when()
            .get("/api/employee")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON);
    }

    /*
package com.example.categorias.controller;

import com.example.categorias.dto.CategoriaDTO;
import com.example.categorias.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaService categoriaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testObtenerCategoriaPorId() throws Exception {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(1L);
        dto.setNombre("Tecnología");
        dto.setEstado("Activo");
        dto.setFechaCreacion(LocalDateTime.now());

        Mockito.when(categoriaService.findById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/categorias/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(dto.getId()))
                .andExpect(jsonPath("$.nombre").value(dto.getNombre()))
                .andExpect(jsonPath("$.estado").value(dto.getEstado()));
    }

    @Test
    void testCrearCategoria() throws Exception {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setNombre("Ciencia");
        dto.setEstado("Activo");

        CategoriaDTO creado = new CategoriaDTO();
        creado.setId(2L);
        creado.setNombre("Ciencia");
        creado.setEstado("Activo");
        creado.setFechaCreacion(LocalDateTime.now());

        Mockito.when(categoriaService.save(Mockito.any(CategoriaDTO.class))).thenReturn(creado);

        mockMvc.perform(post("/api/categorias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(creado.getId()))
                .andExpect(jsonPath("$.nombre").value(creado.getNombre()))
                .andExpect(jsonPath("$.estado").value(creado.getEstado()));
    }

    @Test
    void testObtenerCategoriaNoEncontrada() throws Exception {
        Long idNoExistente = 999L;

        Mockito.when(categoriaService.findById(idNoExistente))
            .thenThrow(new ResourceNotFoundException("Categoría no encontrada con ID: " + idNoExistente));

        mockMvc.perform(get("/api/categorias/{id}", idNoExistente))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.mensaje").value("Categoría no encontrada con ID: " + idNoExistente));
    }

    @Test
    void testEliminarCategoria() throws Exception {
        Long id = 1L;

        // No lanzamos excepción, asumimos eliminación exitosa
        Mockito.doNothing().when(categoriaService).delete(id);

        mockMvc.perform(delete("/api/categorias/{id}", id))
                .andExpect(status().isNoContent());
    }
}                
    */    
}
