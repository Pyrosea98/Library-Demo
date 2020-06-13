package com.desarrollo.biblioteca.service;

import com.desarrollo.biblioteca.modelo.Prestamo;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Servicio de los prestamos
 * @author juan
 */
@Repository
public interface PrestamoService {

    /**
     * Crear prestamo
     * @return el prestamo creado
     */
    public Mono<Prestamo> createPrestamo(Prestamo prestamo);

    /**
     * Borrar prestamo
     */
    public void deletePrestamo(Prestamo prestamo);

    /**
     * Encontrar prestamo por dni e isbn
     * @param dni el dni del usuario
     * @param isbn del libro
     */
    public Mono<Prestamo> findPrestamoById(String dni, String isbn);

    /**
     * Encontrar prestamo por dni e isbn
     * @param dni el dni del usuario
     * @param isbn del libro
     */
    public Prestamo getPrestamoById(String dni, String isbn);

}
