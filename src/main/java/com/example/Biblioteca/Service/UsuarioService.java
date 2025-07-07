package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuario(Long id) throws NoExisteObjectExeption {
        return usuarioRepository.findById(id).orElseThrow(() -> new NoExisteObjectExeption("Usuario no encontrado"));

    }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public void AgregarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void ModificarUsuario(Usuario usuario) {
        System.out.println("No funciona");
    }

    @Override
    public void EliminarUsuario(Long id) {
        usuarioRepository.findById(id).orElseThrow(() -> new NoExisteObjectExeption("El usuario no existe"));
        usuarioRepository.deleteById(id);
    }
}
