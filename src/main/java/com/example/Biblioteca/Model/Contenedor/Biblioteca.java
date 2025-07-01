package com.example.Biblioteca.Model.Contenedor;

import com.example.Biblioteca.Model.Libro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {


    private Map<String, Libro> libros;

    public Biblioteca() {
        this.libros = new HashMap<>();
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
