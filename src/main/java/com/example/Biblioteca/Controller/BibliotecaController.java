package com.example.Biblioteca.Controller;


import com.example.Biblioteca.Model.DTOs.LibroDTO;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Service.BibliotecaService;
import com.example.Biblioteca.Service.DTOs;
import com.example.Biblioteca.Service.LibroService;
import com.example.Biblioteca.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {


    @Autowired
    private BibliotecaService bibliotecaService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private PrestamoService prestamoService;

    private DTOs dtos;

    public BibliotecaController(DTOs dtos) {
        this.dtos = dtos;
    }

    ///Solicitudes Post
   @PostMapping("/realizarPrestamo")
   public String realizarPrestamo(@RequestParam Long idLibro,
                                  @RequestParam Long idUsuario,
                                  @RequestParam LocalDate fechaDevolucion)
   {
       bibliotecaService.realizarPrestamo(idLibro, idUsuario, fechaDevolucion);
       return "Su prestamo se realizo con exito";
   }



                ///Solicitudes Get
    @GetMapping("/consultarLibro/{idLibro}")
    public LibroDTO consultarLibro(@PathVariable Long idLibro)
    {
       Libro libro = libroService.getLibro(idLibro);
       LibroDTO dto = dtos.mapLibroDTO(libro);
       return dto;
    }

    @GetMapping("/todos")
    public List<LibroDTO> traerTodos()
    {
        List<Libro> libros = libroService.getLibros();
        List<LibroDTO> libroDTOs = dtos.mapLibrosDTO(libros);

        return libroDTOs;

    }

    @GetMapping("/prestamos/{idPrestamo}")
    public Prestamo prestamo(@PathVariable Long idPrestamo)
    {
        return prestamoService.getPrestamo(idPrestamo);
    }

    @GetMapping("/filtrarAutor/{idAutor}")
    public List<LibroDTO> filtrarAutor(@PathVariable Long idAutor)
    {
        List<Libro> libros = bibliotecaService.FiltrarPorAutor(idAutor);
        List<LibroDTO> librosDtos = dtos.mapLibrosDTO(libros);

        return librosDtos;
    }

                    ///Solicitudes Put

    @PutMapping("/vender")
    public String venderLibro(@RequestParam String isbn,
                              @RequestParam Long id)
    {
        bibliotecaService.venderLibro(id, isbn);
        return  "Libro vendido con exito, Gracias por su compra";
    }

}
