package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public Usuario getUsuario(Long id) throws NoExisteObjectExeption;
    public List<Usuario> getUsuarios();
    public void AgregarUsuario(Usuario usuario);

    public void ModificarUsuario(Usuario usuario);
    public void EliminarUsuario(Long id);

    public void DevolverLibro(String isbn, Long idUsuario);


}
