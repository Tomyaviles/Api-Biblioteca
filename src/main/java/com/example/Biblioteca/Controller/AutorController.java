package com.example.Biblioteca.Controller;


import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.AutorRepository;
import com.example.Biblioteca.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;


                ///Solicitudes Post

    @PostMapping("/register")
    public String registrarAutor(@RequestBody Autor autor){
        autorService.CargarAutor(autor);

        return "Autor registrado";
    }

    @PostMapping("/libro/{idAutor}")
    public String cargarLibro(@RequestBody Libro libro, @PathVariable Long idAutor){
        autorService.CargarLibro(libro, idAutor);

        return "Libro cargado";
    }

                ///Solicitudes Get

    @GetMapping("/obtener/{idAutor}")
    public Autor obtenerAutor(@PathVariable Long idAutor){
        return autorService.getAutorById(idAutor);
    }

}
