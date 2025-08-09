package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
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

    }

    @Override
    public void EliminarUsuario(Long id) {
        usuarioRepository.findById(id).orElseThrow(() -> new NoExisteObjectExeption("El usuario no existe"));
        usuarioRepository.deleteById(id);
    }

    @Override
    public void DevolverLibro(String isbn, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        for(int i = 0; i < usuario.getPrestamos().size(); i++){
            if (usuario.getPrestamos().get(i).getLibro().getIsbn().equals(isbn)){
                usuario.getPrestamos().get(i).getLibro().disponible();
                usuario.getPrestamos().get(i).devuelto();
            }
        }

    }


    @Override
    public List<Libro> misLibros(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        List<Libro> misLibros = usuario.getMisLibros();

        return misLibros;
    }

    @Override
    public List<Prestamo> misPrestamos(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();

        List<Prestamo> misPrestamos = usuario.getPrestamos();

        return misPrestamos;
    }
}
