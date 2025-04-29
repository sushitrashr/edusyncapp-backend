package com.silvaabanto.edusyncapp_backend.controller;

import com.silvaabanto.edusyncapp_backend.exception.RecursoNoEncontradoException;
import com.silvaabanto.edusyncapp_backend.model.Estudiante;
import com.silvaabanto.edusyncapp_backend.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar Estudiantes.
 */
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    /**
     * Listar todos los estudiantes.
     */
    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return estudianteService.obtenerTodos();
    }

    /**
     * Buscar un estudiante por su ID con HATEOAS.
     */
    @GetMapping("/{id}")
public ResponseEntity<EntityModel<Estudiante>> obtenerPorId(@PathVariable Long id) {
    Estudiante estudiante = estudianteService.obtenerPorId(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Estudiante no encontrado con ID: " + id));

    EntityModel<Estudiante> recurso = EntityModel.of(estudiante);
    recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstudianteController.class).obtenerPorId(id)).withSelfRel());
    recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstudianteController.class).obtenerTodos()).withRel("todos-los-estudiantes"));
    return ResponseEntity.ok(recurso);
    }
    /**
     * Crear un nuevo estudiante.
     */
    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return estudianteService.guardar(estudiante);
    }

    /**
     * Actualizar un estudiante existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        Optional<Estudiante> estudianteExistente = estudianteService.obtenerPorId(id);
        if (estudianteExistente.isPresent()) {
            Estudiante estudiante = estudianteExistente.get();
            estudiante.setNombre(estudianteActualizado.getNombre());
            estudiante.setCorreo(estudianteActualizado.getCorreo());
            estudiante.setCarrera(estudianteActualizado.getCarrera());
            estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());
            estudiante.setEstado(estudianteActualizado.getEstado());
            return ResponseEntity.ok(estudianteService.guardar(estudiante));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar un estudiante por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
