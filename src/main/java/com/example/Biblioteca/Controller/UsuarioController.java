package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.DTOs.UsuarioDTO;
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
        return "Libro devuelto con exitp, Muchisimas Gracias!";
    }
}
