package com.desarrollo.biblioteca.serviceImpl;

import com.desarrollo.biblioteca.dao.UsuarioDAO;
import com.desarrollo.biblioteca.modelo.Usuario;
import com.desarrollo.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Implementacion Service de los usuarios
 * @author juan
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public Mono<Usuario> createUsuario(Usuario usuario) {
        return Mono.just(usuarioDAO.createUsuario(usuario));
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDAO.deleteUsuario(usuario);
    }

    @Override
    public Mono<Usuario> findUsuarioById(String dni) {
        return Mono.just(usuarioDAO.findUsuarioById(dni));
    }

    @Override
    public Usuario getUsuarioById(String dni) {
        return usuarioDAO.findUsuarioById(dni);
    }

    @Override
    public Usuario getUsuarioByCorreo(String correo) {
        return usuarioDAO.findUsuarioByCorreo(correo);
    }
}
