package com.desarrollo.biblioteca.daoImpl;

import com.desarrollo.biblioteca.dao.PrestamoDAO;
import com.desarrollo.biblioteca.modelo.Libro;
import com.desarrollo.biblioteca.modelo.Prestamo;
import com.desarrollo.biblioteca.modelo.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementacion DAO de los libros
 * @author juan
 */
@Repository("prestamoDAO")
@Transactional
public class PrestamoDAOImpl implements PrestamoDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        entityManager.persist(prestamo);
        return prestamo;
    }

    @Override
    public void deletePrestamo(Prestamo prestamo) {
        entityManager.remove(prestamo);
    }

    @Override
    public Prestamo findPrestamoById(String dni, String isbn) {
        return (Prestamo) entityManager.createQuery(
                "select p from  prestamo as p where p.usuario.dni = :dni and p.libro.isbn = :isbn")
                .setParameter("dni", dni).setParameter("isbn", isbn).getSingleResult();
    }
}
