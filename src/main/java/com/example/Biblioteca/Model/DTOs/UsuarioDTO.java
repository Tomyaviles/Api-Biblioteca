package com.example.Biblioteca.Model.DTOs;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private String nombre;
    private String apellido;
    private String email;
    private List<LibroDTO> libros = new ArrayList<>();
    private List<PrestamoDTO> prestamos = new ArrayList<>();


    public UsuarioDTO(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public UsuarioDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<LibroDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    public List<PrestamoDTO> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<PrestamoDTO> prestamos) {
        this.prestamos = prestamos;
    }

    ///Funciones


    public void AgregarLibro(LibroDTO libro) {
        this.libros.add(libro);
    }

    public void AgregarPrestamos(PrestamoDTO prestamo) {
        this.prestamos.add(prestamo);
    }
}
