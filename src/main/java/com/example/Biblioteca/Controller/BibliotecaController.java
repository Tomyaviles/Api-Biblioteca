package com.example.Biblioteca.Controller;


import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Service.BibliotecaService;
import com.example.Biblioteca.Service.LibroService;
import com.example.Biblioteca.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {


    @Autowired
    private BibliotecaService bibliotecaService;

    @Autowired
    private LibroService libroService;

    @Autowired
    private PrestamoService prestamoService;

                    ///Solicitudes Post
   @PostMapping("/realizarPrestamo")
   public String realizarPrestamo(@RequestParam Long idLibro,
                                  @RequestParam Long idUsuario,
                                  @RequestParam LocalDate fechaDevolucion)
   {
       bibliotecaService.realizarPrestamo(idLibro, idUsuario, fechaDevolucion);
       return "Su prestamo se realizo con exito";
   }


    @GetMapping("/consultarLibro/{idLibro}")
    public Libro consultarLibro(@PathVariable Long idLibro)
    {
       return libroService.getLibro(idLibro);
    }

    @GetMapping("/prestamos/{idPrestamo}")
    public Prestamo prestamo(@PathVariable Long idPrestamo)
    {
        return prestamoService.getPrestamo(idPrestamo);
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
