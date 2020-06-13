package com.desarrollo.biblioteca.modelo;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Clase de abstracción de un prestamo
 * @author juan
 */
@Entity(name = "prestamo")
@Table(name = "prestamo", schema = "biblioteca")
public class Prestamo {

    /**
     * identificador autogenerado para indexación de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "prestamo_prestamo_id_seq")
    @SequenceGenerator(name = "prestamo_prestamo_id_seq")
    @Column(name = "prestamo_id")
    private Long prestamo_id;

    /**
     * Fecha de inicio del prestamo
     */
    @Column(name = "fecha_inicio", columnDefinition = "DATE")
    private LocalDate fecha_inicio;

    /**
     * Fecha de fin del prestamo
     */
    @Column(name = "fecha_fin", columnDefinition = "DATE")
    private LocalDate fecha_fin;

    /**
     * Relación con la tabla libro
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id")
    private Libro libro;

    /**
     * Relación con la tabla usuario
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    public Long getPrestamo_id() {
        return prestamo_id;
    }

    public void setPrestamo_id(Long prestamo_id) {
        this.prestamo_id = prestamo_id;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
