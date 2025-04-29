package com.silvaabanto.edusyncapp_backend.controller;

import com.silvaabanto.edusyncapp_backend.exception.RecursoNoEncontradoException;
import com.silvaabanto.edusyncapp_backend.model.Curso;
import com.silvaabanto.edusyncapp_backend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar Cursos.
 */
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    /**
     * Listar todos los cursos.
     */
    @GetMapping
    public List<Curso> obtenerTodos() {
        return cursoService.obtenerTodos();
    }

    /**
     * Buscar un curso por su ID con HATEOAS.
     */
    @GetMapping("/{id}")
public ResponseEntity<EntityModel<Curso>> obtenerPorId(@PathVariable Long id) {
    Curso curso = cursoService.obtenerPorId(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Curso no encontrado con ID: " + id));

    EntityModel<Curso> recurso = EntityModel.of(curso);
    recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).obtenerPorId(id)).withSelfRel());
    recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CursoController.class).obtenerTodos()).withRel("todos-los-cursos"));
    return ResponseEntity.ok(recurso);
    }


    /**
     * Crear un nuevo curso.
     */
    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.guardar(curso);
    }

    /**
     * Actualizar un curso existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        Optional<Curso> cursoExistente = cursoService.obtenerPorId(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNombre(cursoActualizado.getNombre());
            curso.setDescripcion(cursoActualizado.getDescripcion());
            curso.setCreditos(cursoActualizado.getCreditos());
            curso.setEstado(cursoActualizado.getEstado());
            return ResponseEntity.ok(cursoService.guardar(curso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar un curso por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
