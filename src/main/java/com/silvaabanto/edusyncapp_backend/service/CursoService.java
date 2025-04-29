package com.silvaabanto.edusyncapp_backend.service;

import com.silvaabanto.edusyncapp_backend.model.Curso;
import com.silvaabanto.edusyncapp_backend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la lógica de negocio relacionada a Cursos.
 */
@Service
public class CursoService {

    @Autowired // Inyección automática del Repository de Curso.
    private CursoRepository cursoRepository;

    /**
     * Obtener todos los cursos.
     */
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    /**
     * Obtener un curso por su ID.
     */
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    /**
     * Crear o actualizar un curso.
     */
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    /**
     * Eliminar un curso por su ID.
     */
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}
