package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Repository.LibroRepository;
import com.example.Biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BibliotecaService implements IBibliotecaService {

    //Service de Libro
    @Autowired
    private LibroService libroService;

    //Service de usuario
    @Autowired
    private UsuarioService usuarioService;

    //Service de prestamo
    @Autowired
    private PrestamoService prestamoService;

    ///Services de libro y usuario
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void realizarPrestamo(Long usuarioId, Long libroId, LocalDate fechaDevolcion) {
        prestamoService.crearPrestamo(usuarioId, libroId, fechaDevolcion);

    }

    @Override
    public void venderLibro(Long usuarioId, String isbn) {
        Usuario usuario = usuarioService.getUsuario(usuarioId);
        Libro libro = libroService.getLibroIsbn(isbn);
        libro.vendido();
        libro.setUsuario(usuario);
        usuario.agregarLibro(libro);
        libroRepository.save(libro);
        usuarioRepository.save(usuario);

    }

    @Override
    public void AgregarLibroBiblioteca(Libro libro) {
        libroService.AgregarLibro(libro);
    }
}
