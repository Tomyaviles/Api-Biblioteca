package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;

import java.util.List;

public interface ILibroServie {

    public void AgregarLibro(Libro libro);

    public Libro getLibro(Long id);
    public List<Libro> getLibros();
    public void EliminarLibro(Long id);
}
