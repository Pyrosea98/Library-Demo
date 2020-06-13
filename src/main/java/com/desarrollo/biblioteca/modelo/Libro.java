package com.desarrollo.biblioteca.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase de abstracción de un libro
 *
 * @author juan
 */
@Entity(name = "libro")
@Table(name = "libro", schema = "biblioteca")
public class Libro implements Serializable {

    /**
     * identificador autogenerado para indexación de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libro_id")
    private Long libro_id;

    /**
     * titulo del libro
     */
    @Column(name = "titulo", length = 200)
    private String titulo;

    /**
     * Este campo se refiere al ISBN
     */
    @Column(name = "isbn", length = 50)
    private String isbn;

    /**
     * Categoría del libro para filtros
     */
    @Column(name = "categoria", length = 100)
    private String categoria;

    /**
     * Campo de la URL de la imagen
     */
    @Column(name = "imagen_url", length = 2048)
    private String imagen_url;

    public Long getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Long libro_id) {
        this.libro_id = libro_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoría(String categoria) {
        this.categoria = categoria;
    }
}