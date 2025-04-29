package com.silvaabanto.edusyncapp_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Clase Entidad que representa un Estudiante en la base de datos.
 */
@Entity // Anotación que indica que esta clase es una tabla en la base de datos.
@Data // Anotación de Lombok para generar getters, setters, toString automáticamente.
public class Estudiante {

    @Id // Anotación que indica la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementa el ID en la base de datos.
    private Long id;

    private String nombre;

    private String correo;

    private String carrera;

    private String fechaNacimiento; // Usamos String para simplicidad, pero luego podrías cambiarlo a LocalDate.

    private String estado; // Puede ser "Activo" o "Inactivo".

    // No necesitamos getters y setters manuales gracias a @Data (Lombok los crea automáticamente).

}
