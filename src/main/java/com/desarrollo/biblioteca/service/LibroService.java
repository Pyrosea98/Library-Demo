package com.desarrollo.biblioteca.service;

import com.desarrollo.biblioteca.modelo.Libro;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Servicio de los libros
 * @author juan
 */
@Service
public interface LibroService {

    /**
     * Lista de todos los libros
     * @return todos los libros
     */
    public Flux<Libro> getAllLibros();

    /**
     * Lista con libros disponibles
     * @return los libros disponibles
     */
    public Flux<Libro> getLibrosLibres();

    /**
     * Lista con libros en prestamos
     * @param dni el dni del usuario
     * @return libros en prestamo
     */
    public Flux<Libro> getLibrosPrestamo(String dni);

    /**
     * Busqueda de libro por ISBN
     * @param isbn el isbn del libro
     * @return el libro con ese isbn
     */
    public Mono<Libro> getLibroByISBN(String isbn);

    /**
     * Lista de libros con una categoría en especifico
     * @return los libros con dicha categoría
     */
    public Flux<Libro> getLibrosByCategoria(String categoria);

}
