package com.example.Biblioteca.Model.DTOs;

import com.example.Biblioteca.Model.Genero;

public class LibroDTO {

    private String titulo;
    private String nombreAutor;
    private Genero genero;
    private String isbn;
    private int anio;

    public LibroDTO(String titulo, String nombreAutor, String isbn, int anio, Genero genero) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.genero = genero;
        this.isbn = isbn;
        this.anio = anio;
    }

    public LibroDTO() {
    }

                        //GETTERS Y SETTERS


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
