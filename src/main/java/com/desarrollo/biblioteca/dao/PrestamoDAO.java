package com.desarrollo.biblioteca.dao;

import com.desarrollo.biblioteca.modelo.Libro;
import com.desarrollo.biblioteca.modelo.Prestamo;
import com.desarrollo.biblioteca.modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO de los prestamos
 * @author juan
 */
@Repository
public interface PrestamoDAO {

    /**
     * Crear prestamo
     * @return el prestamo creado
     */
    public Prestamo createPrestamo(Prestamo prestamo);

    /**
     * Borrar prestamo
     */
    public void deletePrestamo(Prestamo prestamo);

    /**
     * Encontrar prestamo por dni e isbn
     * @param dni el dni del usuario
     * @param isbn del libro
     */
    public Prestamo findPrestamoById(String dni, String isbn);
}
