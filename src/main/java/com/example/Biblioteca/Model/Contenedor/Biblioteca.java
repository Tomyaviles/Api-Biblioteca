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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    
}
