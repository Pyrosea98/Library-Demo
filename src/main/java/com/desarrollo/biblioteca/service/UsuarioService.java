package com.desarrollo.biblioteca.service;

import com.desarrollo.biblioteca.modelo.Usuario;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Servicio de los usuarios
 * @author juan
 */
@Repository
public interface UsuarioService {

    /**
     * Crear usuario
     * @return el usuario creado
     */
    public Mono<Usuario> createUsuario(Usuario usuario);

    /**
     * Borrar usuario
     */
    public void deleteUsuario(Usuario usuario);

    /**
     * Encontrar usuario por dni
     * @param dni el dni del usuario
     */
    public Mono<Usuario> findUsuarioById(String dni);

    /**
     * Encontrar usuario por dni
     * @param dni el dni del usuario
     */
    public Usuario getUsuarioById(String dni);

}
