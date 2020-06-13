package com.desarrollo.biblioteca.controlador;

import com.desarrollo.biblioteca.modelo.Prestamo;
import com.desarrollo.biblioteca.serviceImpl.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Controlador rest de prestamos
 * @author juan
 */
@RestController
public class PrestamoController{

    @Autowired
    PrestamoServiceImpl prestamoService;

    /**
     * Registro de prestamo
     * @param prestamo el prestamo
     * @return el prestamo creado
     */
    @PostMapping(value = "/loan/validate")
    public Mono<Prestamo> createPrestamo(@Valid @RequestBody Prestamo prestamo){
        return this.prestamoService.createPrestamo(prestamo);
    }

    /**
     * Desregistro de prestamo
     * @param dni el dni del usuario
     * @param isbn el isbn del libro
     * @return resgitro de borrado de prestamo
     */
    @DeleteMapping(value = "/loan/{dni}/{isbn}/delete")
    public Mono<ResponseEntity<String>> deletePrestamo(@PathVariable(value = "dni") String dni, @PathVariable(value = "isbn") String isbn){
        Prestamo prestamo = prestamoService.getPrestamoById(dni, isbn);
        prestamoService.deletePrestamo(prestamo);
        return Mono.just(new ResponseEntity<>("Borrado completo", HttpStatus.ACCEPTED));
    }

    @GetMapping(value = "/user/{dni}/{isbn}")
    public Mono<Prestamo> getPrestamo(@PathVariable(value = "dni") String dni, @PathVariable(value = "isbn") String isbn){
        return this.prestamoService.findPrestamoById(dni, isbn);
    }

}
