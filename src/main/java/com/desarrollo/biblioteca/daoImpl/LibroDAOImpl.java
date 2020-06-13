package com.desarrollo.biblioteca.daoImpl;

import com.desarrollo.biblioteca.dao.LibroDAO;
import com.desarrollo.biblioteca.modelo.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementacion DAO de los libros
 *
 * @author juan
 */
@Repository("libroDAO")
@Transactional
public class LibroDAOImpl implements LibroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Libro> getAllLibros() {
        return (List<Libro>) entityManager.createQuery(
                "select l from libro as l order by  l.titulo").getResultList();
    }

    @Override
    public List<Libro> getLibrosLibres() {
        return (List<Libro>) entityManager.createQuery(
                "select l from libro as l where l not in (select l from prestamo as p inner join p.libro as l) order by l.titulo").getResultList();
    }

    @Override
    public List<Libro> getLibrosPrestamo(String dni) {
        return (List<Libro>) entityManager.createQuery(
                "select l from prestamo as p inner join p.libro as l where p.usuario.dni = :dni order by l.titulo").
                setParameter("dni", dni).getResultList();
    }

    @Override
    public Libro getLibroByISBN(String isbn) {
        return (Libro) entityManager.createQuery(
                "select l from  libro  as l where l.isbn = :isbn").setParameter("isbn", isbn).getSingleResult();
    }

    @Override
    public List<Libro> getLibrosByCategoria(String categoria) {
        return (List<Libro>) entityManager.createQuery(
                "select l from  libro  as l where l.categoría = :categoria").setParameter("categoria", categoria).getResultList();
    }
}
