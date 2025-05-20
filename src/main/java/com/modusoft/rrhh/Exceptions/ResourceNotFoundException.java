/**
 * Permite personalizar mensajes de Recursos no encontrados.
 *
 * @author Jayson Pinilla
 * 
 */

package com.modusoft.rrhh.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}