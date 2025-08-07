package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;

import java.time.LocalDate;

public interface IBibliotecaService {


    public void realizarPrestamo(Long usuarioId, Long libroId, LocalDate fechaDevolucion);

    public void venderLibro(Long usuarioId, Long libroId);


    public void AgregarLibroBiblioteca(Libro libro);

}
