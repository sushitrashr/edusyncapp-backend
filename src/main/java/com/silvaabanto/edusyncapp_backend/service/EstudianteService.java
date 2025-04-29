package com.silvaabanto.edusyncapp_backend.service;

import com.silvaabanto.edusyncapp_backend.model.Estudiante;
import com.silvaabanto.edusyncapp_backend.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la lógica de negocio relacionada a Estudiantes.
 */
@Service
public class EstudianteService {

    @Autowired // Inyección de dependencias: Spring Boot inyecta automáticamente el Repository.
    private EstudianteRepository estudianteRepository;

    /**
     * Obtener todos los estudiantes.
     */
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    /**
     * Obtener un estudiante por su ID.
     */
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    /**
     * Crear o actualizar un estudiante.
     */
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Eliminar un estudiante por su ID.
     */
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
