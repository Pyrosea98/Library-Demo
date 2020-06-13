package com.desarrollo.biblioteca.daoImpl;

import com.desarrollo.biblioteca.dao.UsuarioDAO;
import com.desarrollo.biblioteca.modelo.Libro;
import com.desarrollo.biblioteca.modelo.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Implementacion DAO de los libros
 * @author juan
 */
@Repository("UsuarioDAO")
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Usuario createUsuario(Usuario Usuario) {
        entityManager.persist(Usuario);
        return Usuario;
    }

    @Override
    public void deleteUsuario(Usuario Usuario) {
        entityManager.remove(Usuario);
    }

    @Override
    public Usuario findUsuarioById(String dni) {
        return (Usuario) entityManager.createQuery(
                "select u from  usuario  as u where u.dni = :dni").setParameter("dni", dni).getSingleResult();
    }
}
