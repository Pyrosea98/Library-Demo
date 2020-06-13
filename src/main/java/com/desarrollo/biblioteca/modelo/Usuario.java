package com.desarrollo.biblioteca.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase de abstracción de un usuario
 * @author juan
 */
@Entity(name = "usuario")
@Table(name = "usuario", schema = "biblioteca")
public class Usuario implements Serializable {

    /**
     * identificador autogenerado para indexación de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_usuario_id_seq")
    @SequenceGenerator(name = "usuario_usuario_id_seq")
    @Column(name = "usuario_id")
    private Long usuario_id;

    /**
     * Nombre real del usuario
     */
    @Column(name = "nombre", length = 255)
    private String nombre;

    /**
     * Apellido real del usuario
     */
    @Column(name = "apellido", length = 255)
    private String apellido;

    /**
     * Correo del usuario
     */
    @Column(name = "correo", length = 1000)
    private String correo;

    /**
     * Alfanumerico del documento nacional de identificación
     */
    @Column(name = "dni", length = 100)
    private String dni;

    /**
     * clave del usuario
     */
    @Column(name = "clave", length = 100)
    private String clave;

    /**
     * Número de telefono del usuario
     */
    @Column(name = "numero_telefono", length = 20)
    private String numero_telefono;

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
}
