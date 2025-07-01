package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Autor(String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        super(nombre, apellido, email, fechaNacimiento);
        this.libros = new ArrayList<>();
    }
    public Autor() {
        this.libros = new ArrayList<>();
    }

                ///GETTER Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
