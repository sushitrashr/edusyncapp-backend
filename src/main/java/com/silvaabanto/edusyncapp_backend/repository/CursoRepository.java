package com.silvaabanto.edusyncapp_backend.repository;

import com.silvaabanto.edusyncapp_backend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Curso que extiende JpaRepository.
 * Permite realizar operaciones CRUD automáticamente.
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Aquí puedes definir consultas personalizadas si las necesitas más adelante.
}
