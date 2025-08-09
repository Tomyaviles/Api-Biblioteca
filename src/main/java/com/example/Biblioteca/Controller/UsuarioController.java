package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.DTOs.LibroDTO;
import com.example.Biblioteca.Model.DTOs.PrestamoDTO;
import com.example.Biblioteca.Model.DTOs.UsuarioDTO;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Service.DTOs;
import com.example.Biblioteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private DTOs dtos;

    public UsuarioController(DTOs dtos) {
        this.dtos = dtos;
    }

    ///Solicitudes Get

    @GetMapping("/{idUsuario}")
    public UsuarioDTO getUsuario(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.getUsuario(idUsuario);

        System.out.println(usuario.getPrestamos().get(0).getLibro().getTitulo());
        UsuarioDTO usuarioDTO = dtos.mapUsuarioDTO(usuario);
        return usuarioDTO;


    }

    @GetMapping("/todos")
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        List<UsuarioDTO> usuariosDTO = dtos.mapUsuarioDTO(usuarios);
        return usuariosDTO;
    }


    @GetMapping("/misLibros/{idUsuario}")
    public List<LibroDTO> getUsuariosLibros(@PathVariable Long idUsuario) {
        List<Libro> libros = usuarioService.misLibros(idUsuario);
        List<LibroDTO> librosDto = dtos.mapLibrosDTO(libros);
        return librosDto;
    }

    @GetMapping("/misPrestamos/{idUsuario}")
    public List<PrestamoDTO> getUsuarioPrestamo(@PathVariable Long idUsuario)
    {
        List<Prestamo> prestamos = usuarioService.misPrestamos(idUsuario);
        List<PrestamoDTO> prestamosDto = dtos.mapPrestamosDTO(prestamos);

        return prestamosDto;
    }

                    ///Solicitudes Post

    @PostMapping("/register")
    public void RegitrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.AgregarUsuario(usuario);

    }


                ///Solicitudes Delete
    @DeleteMapping("/delete/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.EliminarUsuario(id);
        return "Usuario eliminado com sucesso!";
    }



                    ///Solicitudes PUT

    @PutMapping("/devolver")
    public String devolverUsuario(@RequestParam Long id,
                                  @RequestParam String isbn) {
        usuarioService.DevolverLibro(isbn, id);
        return "Libro devuelto con exito, Muchisimas Gracias!";
    }
}
