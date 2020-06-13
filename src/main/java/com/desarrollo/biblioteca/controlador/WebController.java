package com.desarrollo.biblioteca.controlador;

import com.desarrollo.biblioteca.dao.LibroDAO;
import com.desarrollo.biblioteca.dao.PrestamoDAO;
import com.desarrollo.biblioteca.dao.UsuarioDAO;
import com.desarrollo.biblioteca.modelo.Prestamo;
import com.desarrollo.biblioteca.modelo.Usuario;
import com.desarrollo.biblioteca.serviceImpl.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

/**
 * Controlador de la pagina
 *
 * @author juan
 */
@Controller
public class WebController {

    @Autowired
    LibroDAO libroDAO;

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    PrestamoDAO prestamoDAO;

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("libros", libroDAO.getLibrosLibres());
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "register";
    }

    @GetMapping("/index_user")
    public String getIndexUser(@RequestParam(name = "correo", required = true) String correo,
                               @RequestParam(name = "clave", required = true) String clave,
                               Model model) {
        try {
            Usuario user = usuarioDAO.findUsuarioByCorreo(correo);
            if (user != null) {
                if (user.getClave().equals(clave)) {
                    model.addAttribute("usuario", user);
                    model.addAttribute("libros", libroDAO.getLibrosLibres());

                    return "index_user";
                }
            }
            return "login";
        }catch (javax.persistence.NoResultException e){
            return "login";
        }
    }

    @GetMapping("/prestamo")
    public String getIndex0(@RequestParam(name = "correo", required = true) String correo,
                            @RequestParam(name = "isbn", required = true) String isbn,
                            Model model, Prestamo prestamo) {
        model.addAttribute("libro", libroDAO.getLibroByISBN(isbn));
        model.addAttribute("usuario", usuarioDAO.findUsuarioByCorreo(correo));
        model.addAttribute("prestamo", prestamo);
        return "prestamo";
    }
}
