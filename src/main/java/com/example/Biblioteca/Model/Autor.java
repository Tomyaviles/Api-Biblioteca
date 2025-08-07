package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor extends Persona {


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



    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

                ///Metodos

    public void AgregarLibro(Libro libro)
    {
        libros.add(libro);
    }
}
