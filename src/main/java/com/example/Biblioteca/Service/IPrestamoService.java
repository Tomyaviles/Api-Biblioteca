package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Usuario;

import java.time.LocalDate;

public interface IPrestamoService {

    public void crearPrestamo(Long libroId, Long usuarioId, LocalDate fechaDevolucion);
}
