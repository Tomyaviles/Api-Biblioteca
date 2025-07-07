package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Repository.LibroRepository;
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


    @Override
    public void realizarPrestamo(Long usuarioId, Long libroId, LocalDate fechaDevolcion) {
        prestamoService.crearPrestamo(usuarioId, libroId, fechaDevolcion);

    }

    @Override
    public void venderLibro(Long usuarioId, Long libroId) {

    }
}
