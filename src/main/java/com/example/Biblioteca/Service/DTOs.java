package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.DTOs.AutorDTO;
import com.example.Biblioteca.Model.DTOs.LibroDTO;
import com.example.Biblioteca.Model.DTOs.PrestamoDTO;
import com.example.Biblioteca.Model.DTOs.UsuarioDTO;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOs {


                    ///AUTOR

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

                    ///LIBRO

    public LibroDTO mapLibroDTO(Libro libro){
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAnio(libro.getAnioPublicacion());
        libroDTO.setNombreAutor(libro.getAutor().getNombre());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setGenero(libro.getGenero());

        return libroDTO;
    }


                    ///USUARIO

    public UsuarioDTO mapUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setApellido(usuario.getApellido());
        if (usuario.getMisLibros().isEmpty()) {
            for (Libro libro : usuario.getMisLibros()) {
                LibroDTO libroDTO = mapLibroDTO(libro);
                usuarioDTO.AgregarLibro(libroDTO);
            }
        }

        if (usuario.getPrestamos().isEmpty()) {
            for (Prestamo prestamo : usuario.getPrestamos()) {
                PrestamoDTO prestamoDTO = mapPrestamoDTO(prestamo);
                usuarioDTO.AgregarPrestamos(prestamoDTO);
            }
        }
        return usuarioDTO;
    }

    public List<UsuarioDTO> mapUsuarioDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(mapUsuarioDTO(usuario));
        }

        return usuarioDTOs;
    }


                    ///Prestamos

    public PrestamoDTO mapPrestamoDTO(Prestamo prestamo)
    {
        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.setFechaDevolucion(prestamo.getFechaDevolucion());
        prestamoDTO.setUsuario(prestamo.getUsuario().getNombre());
        prestamoDTO.setTitulolibro(prestamo.getLibro().getTitulo());
        return prestamoDTO;
    }

    public List<PrestamoDTO> mapPrestamosDTO(List<Prestamo> prestamos) {
        List<PrestamoDTO> prestamoDTOs = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            prestamoDTOs.add(mapPrestamoDTO(prestamo));
        }
        return prestamoDTOs;
    }
}
