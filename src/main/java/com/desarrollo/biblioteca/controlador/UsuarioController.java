package com.desarrollo.biblioteca.controlador;

import com.desarrollo.biblioteca.modelo.Usuario;
import com.desarrollo.biblioteca.serviceImpl.UsuarioServiceImpl;
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
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    /**
     * Registro de usuario
     * @param usuario el usuario
     * @return el usuario creado
     */
    @PostMapping(value = "/register/validate")
    public Mono<Usuario> createUsuario(@Valid @RequestBody Usuario usuario){
        return this.usuarioService.createUsuario(usuario);
    }

    /**
     * Desregistro de usuario
     * @param dni el dni del usuario
     * @return resgitro de borrado de usuario
     */
    @DeleteMapping(value = "/user/{dni}/delete")
    public Mono<ResponseEntity<String>> deleteUsuario(@PathVariable(value = "dni") String dni){
        Usuario usuario = usuarioService.getUsuarioById(dni);
        usuarioService.deleteUsuario(usuario);
        return Mono.just(new ResponseEntity<>("Borrado completo", HttpStatus.ACCEPTED));
    }

    @GetMapping(value = "/user/{dni}")
    public Mono<Usuario> getUsuario(@PathVariable(value = "dni") String dni){
        return this.usuarioService.findUsuarioById(dni);
    }

}
