package com.desarrollo.biblioteca.dao;

import com.desarrollo.biblioteca.modelo.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO de los libros
 * @author juan
 */
@Repository
public interface LibroDAO {

    /**
     * Lista de todos los libros
     * @return todos los libros
     */
    public List<Libro> getAllLibros();

    /**
     * Lista con libros disponibles
     * @return los libros disponibles
     */
    public List<Libro> getLibrosLibres();

    /**
     * Lista con libros en prestamos
     * @param dni el dni del usuario
     * @return libros en prestamo
     */
    public List<Libro> getLibrosPrestamo(String dni);

    /**
     * Busqueda de libro por ISBN
     * @param isbn el isbn del libro
     * @return el libro con ese isbn
     */
    public Libro getLibroByISBN(String isbn);

    /**
     * Lista de libros con una categoría en especifico
     * @return los libros con dicha categoría
     */
    public List<Libro> getLibrosByCategoria(String categoria);

}
