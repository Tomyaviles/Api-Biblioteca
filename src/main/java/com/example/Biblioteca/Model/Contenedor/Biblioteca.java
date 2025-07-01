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
@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Map<String, Libro> libros;

    public Biblioteca() {
        this.libros = new HashMap<>();
    }

                    ///GETTER Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Libro> getLibros() {
        return libros;
    }

    public void setLibros(Map<String,Libro> libros) {
        this.libros = libros;
    }



                ///METODOS

    ///Agregar libro
   public void AgregarLibro(Libro libro) {
        libros.put(libro.getTitulo(), libro);
   }


   ///Buscar por isbn
    public Libro BuscarPorIsbn(String isbn) {
        return libros.get(isbn);
    }





    
}
