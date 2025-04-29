package com.silvaabanto.edusyncapp_backend.exception;

/**
 * Excepción personalizada para recursos no encontrados (404 Not Found).
 */
public class RecursoNoEncontradoException extends RuntimeException {

    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
