package com.desarrollo.biblioteca.controlador;

import com.desarrollo.biblioteca.modelo.Libro;
import com.desarrollo.biblioteca.serviceImpl.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador rest de prestamos
 * @author juan
 */
@RestController
public class LibroController {

    @Autowired
    LibroServiceImpl libroService;

    /**
     * Obtener todos los libros
     * @return flujo de datos con todos los libros
     */
    @GetMapping(value = "/libros")
    public Flux<Libro> allLibros(){
        return this.libroService.getAllLibros();
    }

    /**
     * Obtener todos los libros libres
     * @return flujo de datos con todos los libros libres
     */
    @GetMapping(value = "/libres")
    public Flux<Libro> librosLibres(){
        return this.libroService.getLibrosLibres();
    }

    /**
     * Obtener todos los libros en prestamo
     * @param dni el dni del usuario
     * @return flujo de datos con todos los libros en prestamo
     */
    @GetMapping(value = "/prestamos/{dni}")
    public Flux<Libro> librosPrestamo(@PathVariable(value = "dni") String dni){
        return this.libroService.getLibrosPrestamo(dni);
    }

    /**
     * Obtener todos los libros en prestamo
     * @param categoria categoria del libro
     * @return flujo de datos con todos los libros en prestamo
     */
    @GetMapping(value = "/libros/filter/{categoria}/categoria")
    public Flux<Libro> librosCategoria(@PathVariable(value = "categoria") String categoria){
        return this.libroService.getLibrosByCategoria(categoria);
    }

    /**
     * Obtener todos los libros en prestamo
     * @param isbn el isbn del libro
     * @return flujo de datos con todos los libros en prestamo
     */
    @GetMapping(value = "/libros/filter/{isbn}/isbn")
    public Mono<Libro> lisbroISBN(@PathVariable(value = "isbn") String isbn){
        return this.libroService.getLibroByISBN(isbn);
    }
}
