package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.DTOs.AutorDTO;
import com.example.Biblioteca.Model.DTOs.LibroDTO;
import com.example.Biblioteca.Model.Libro;
import org.springframework.stereotype.Service;

@Service
public class DTOs {

    public AutorDTO mapAutorDTO(Autor autor){
        AutorDTO autorDTO = new AutorDTO();

        autorDTO.setNombre(autor.getNombre());
        autorDTO.setEmail(autor.getEmail());

        for (Libro libro : autor.getLibros()){
            LibroDTO libroDTO = mapLibroDTO(libro);
            autorDTO.getLibros().add(libroDTO);
        }

        return autorDTO;
    }

    public LibroDTO mapLibroDTO(Libro libro){
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAnio(libro.getAnioPublicacion());
        libroDTO.setNombreAutor(libro.getAutor().getNombre());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setGenero(libro.getGenero());

        return libroDTO;
    }
}
