package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Libro;

import java.time.LocalDate;
import java.util.List;

public interface IBibliotecaService {


    public void realizarPrestamo(Long usuarioId, Long libroId, LocalDate fechaDevolucion);

    public void venderLibro(Long usuarioId, String isbn);

    public List<Libro> FiltrarPorAutor(Long idAutor);
    public void AgregarLibroBiblioteca(Libro libro);

}
