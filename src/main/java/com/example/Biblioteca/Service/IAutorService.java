package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.Libro;

import java.util.List;

public interface IAutorService {

    public void CargarAutor(Autor autor);
    public void CargarLibro(Libro libro, Long id);
    public Autor getAutorById(Long id);
    public List<Autor> getAllAutors();
}
