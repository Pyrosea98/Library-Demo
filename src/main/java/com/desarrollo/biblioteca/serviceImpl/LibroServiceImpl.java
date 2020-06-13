package com.desarrollo.biblioteca.serviceImpl;

import com.desarrollo.biblioteca.dao.LibroDAO;
import com.desarrollo.biblioteca.modelo.Libro;
import com.desarrollo.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion Service de los libros
 * @author juan
 */
@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroDAO libroDAO;


    @Override
    public Flux<Libro> getAllLibros() {
        return Flux.fromIterable(libroDAO.getAllLibros());
    }

    @Override
    public Flux<Libro> getLibrosLibres() {
        return Flux.fromIterable(libroDAO.getLibrosLibres());
    }

    @Override
    public Flux<Libro> getLibrosPrestamo(String dni) {
        return Flux.fromIterable(libroDAO.getLibrosPrestamo(dni));
    }

    @Override
    public Mono<Libro> getLibroByISBN(String isbn) { return Mono.just(libroDAO.getLibroByISBN(isbn)); }

    @Override
    public Flux<Libro> getLibrosByCategoria(String categoria) { return Flux.fromIterable(libroDAO.getLibrosByCategoria(categoria)); }
}
