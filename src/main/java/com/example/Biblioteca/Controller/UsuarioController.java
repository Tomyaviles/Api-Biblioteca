package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
}
