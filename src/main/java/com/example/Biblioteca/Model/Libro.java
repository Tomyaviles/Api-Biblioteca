package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private int AnioPublicacion;

    private String isbn;

    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    ///En caso de que sea vendido
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos;

    public Libro(String titulo, int anioPublicacion, String isbn, Genero genero, List<Prestamo> prestamos, Autor autor) {
        this.titulo = titulo;
        AnioPublicacion = anioPublicacion;
        this.isbn = isbn;
        this.genero = genero;
        this.prestamos = prestamos;
        this.autor = autor;
    }

    public Libro() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return AnioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        AnioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
