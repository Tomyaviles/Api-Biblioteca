package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroService libroService;



    @Override
    public void CargarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    public void CargarLibro(Libro libro, Long id) {
        Autor autor = autorRepository.findById(id).get();
        libro.setAutor(autor);
        autor.AgregarLibro(libro);
        libroService.AgregarLibro(libro);
        autorRepository.save(autor);

    }

    @Override
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).get();
    }

    @Override
    public List<Autor> getAllAutors() {
        List<Autor> autors = autorRepository.findAll();
        return autors;
    }
}
