package com.example.Biblioteca.Model.DTOs;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {

    private String nombre;
    private String email;
    private List<LibroDTO> libros = new ArrayList<>();

    public AutorDTO(Long id, String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public AutorDTO() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
