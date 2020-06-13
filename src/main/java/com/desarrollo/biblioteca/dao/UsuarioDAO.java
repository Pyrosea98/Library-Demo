package com.desarrollo.biblioteca.dao;

import com.desarrollo.biblioteca.modelo.Usuario;
import org.springframework.stereotype.Repository;

/**
 * DAO de los usuarios
 * @author juan
 */
@Repository
public interface UsuarioDAO {

    /**
     * Crear usuario
     * @return el usuario creado
     */
    public Usuario createUsuario(Usuario usuario);

    /**
     * Borrar usuario
     */
    public void deleteUsuario(Usuario usuario);

    /**
     * Encontrar usuario por dni
     * @param dni el dni del usuario
     */
    public Usuario findUsuarioById(String dni);

    /**
     * Encontrar usuario por correo
     * @param correo el correo del usuario
     */
    public Usuario findUsuarioByCorreo(String correo);
}
