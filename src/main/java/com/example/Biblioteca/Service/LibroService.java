package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.LibroVendidoException;
import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.LibroRepository;
import org.aspectj.lang.NoAspectBoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        Libro libro = libroRepository.findById(id).orElseThrow(() -> new NoExisteObjectExeption("No existe el libro"));

        if (libro.isVendido())
        {
            throw new LibroVendidoException("Libro no disponible");
        }

        return libro;
    }

    @Override
    public List<Libro> getLibros() {
        List<Libro> libros = libroRepository.findAll();
        List<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (!libro.isVendido())
            {
                ///Aca agregamos una validacion para retornar todos los libros que no fueron vendidos
                resultado.add(libro);
            }
        }
        return resultado;
    }

    @Override
    public void EliminarLibro(Long id) {

        libroRepository.deleteById(id);
    }
}
