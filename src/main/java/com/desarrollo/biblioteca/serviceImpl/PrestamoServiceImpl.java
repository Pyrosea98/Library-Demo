package com.desarrollo.biblioteca.serviceImpl;

import com.desarrollo.biblioteca.dao.PrestamoDAO;
import com.desarrollo.biblioteca.modelo.Prestamo;
import com.desarrollo.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementacion Service de los prestamos
 *
 * @author juan
 */
@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoDAO prestamoDAO;

    @Override
    public Mono<Prestamo> createPrestamo(Prestamo prestamo) {
        return Mono.just(prestamoDAO.createPrestamo(prestamo));
    }

    @Override
    public void deletePrestamo(Prestamo prestamo) {
        prestamoDAO.deletePrestamo(prestamo);
    }

    @Override
    public Mono<Prestamo> findPrestamoById(String dni, String isbn) {
        return Mono.just(prestamoDAO.findPrestamoById(dni, isbn));
    }

    @Override
    public Prestamo getPrestamoById(String dni, String isbn) {
        return prestamoDAO.findPrestamoById(dni, isbn);
    }
}
