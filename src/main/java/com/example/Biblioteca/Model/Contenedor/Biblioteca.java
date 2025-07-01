package com.example.Biblioteca.Model.Contenedor;

import com.example.Biblioteca.Model.Libro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {


    private Long id;
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

                    ///GETTER Y SETTERS

    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }


    ///METODOS
/*
    ///Agregar libro
   public void AgregarLibro(Libro libro) {
        libros.put(libro.getTitulo(), libro);
   }


   ///Buscar por isbn
    public Libro BuscarPorIsbn(String isbn) {
        return libros.get(isbn);
    }


*/


    
}
