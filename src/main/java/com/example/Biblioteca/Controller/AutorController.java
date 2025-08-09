package com.example.Biblioteca.Controller;


import com.example.Biblioteca.Model.Autor;
import com.example.Biblioteca.Model.DTOs.AutorDTO;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Repository.AutorRepository;
import com.example.Biblioteca.Service.AutorService;
import com.example.Biblioteca.Service.DTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    private DTOs dtos;

    public AutorController(DTOs dtos) {
        this.dtos = dtos;
    }


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
    public AutorDTO obtenerAutor(@PathVariable Long idAutor){
        Autor autor = autorService.getAutorById(idAutor);
        AutorDTO autorDTO = dtos.mapAutorDTO(autor);

        return autorDTO;
    }

    @GetMapping("/todos")
    public List<AutorDTO> obtenerTodosLosAutores()
    {
        List<Autor> autors = autorService.getAllAutors();
        List<AutorDTO> autorsDTO = dtos.mapAutoresDTO(autors);

        return autorsDTO;
    }

                ///Solicitudes Delete

    @DeleteMapping("/delete/{id}")
    public String eliminarAutor(@PathVariable Long id){

        return "Autor eliminado con exito";
    }
}
