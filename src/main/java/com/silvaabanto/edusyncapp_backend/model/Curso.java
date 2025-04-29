package com.silvaabanto.edusyncapp_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Clase Entidad que representa un Curso en la base de datos.
 */
@Entity // Anotación que convierte esta clase en una tabla de base de datos.
@Data // Anotación de Lombok que genera automáticamente getters, setters, toString, etc.
public class Curso {

    @Id // Marca el atributo id como clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID (auto-incremental).
    private Long id;

    private String nombre;

    private String descripcion;

    private Integer creditos; // Número de créditos académicos del curso.

    private String estado; // Estado del curso: "Activo" o "Inactivo".

    // Gracias a Lombok, no necesitamos escribir manualmente getters, setters ni constructores.
}
