package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.LibroRepository;
import org.aspectj.lang.NoAspectBoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroServie {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void AgregarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public Libro getLibro(Long id) {
        return libroRepository.findById(id).orElseThrow(() -> new NoExisteObjectExeption("No existe el libro"));
    }

    @Override
    public List<Libro> getLibros() {
        List<Libro> libros = libroRepository.findAll();

        return libros;
    }

    @Override
    public void EliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
