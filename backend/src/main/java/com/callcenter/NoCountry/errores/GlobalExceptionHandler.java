package com.callcenter.NoCountry.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controlador global para manejar excepciones en la aplicación.
 * Esta clase captura y maneja las excepciones no controladas que ocurren en la aplicación
 * y devuelve una respuesta adecuada al cliente con el mensaje de error y el estado HTTP correspondiente.
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manejador global de excepciones.
     *
     * Este método captura cualquier excepción de tipo {@link Exception} que no haya sido
     * manejada previamente, y devuelve una respuesta con el código de estado HTTP 500 (Internal Server Error)
     * junto con el mensaje de error detallado.
     *
     * @param e La excepción que ha sido lanzada.
     * @return Una respuesta con el estado HTTP 500 y un mensaje detallado del error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error: " + e.getMessage());
    }
}

