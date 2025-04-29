package com.silvaabanto.edusyncapp_backend.repository;

import com.silvaabanto.edusyncapp_backend.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Estudiante que extiende JpaRepository.
 * Permite realizar operaciones CRUD automáticamente.
 */
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Aquí puedes definir consultas personalizadas si las necesitas más adelante.
}
