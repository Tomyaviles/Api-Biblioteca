package com.example.Biblioteca.Service;

import com.example.Biblioteca.Exceptions.NoExisteObjectExeption;
import com.example.Biblioteca.Model.Estado;
import com.example.Biblioteca.Model.Libro;
import com.example.Biblioteca.Model.Prestamo;
import com.example.Biblioteca.Model.Usuario;
import com.example.Biblioteca.Repository.LibroRepository;
import com.example.Biblioteca.Repository.PrestamoRepository;
import com.example.Biblioteca.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrestamoService implements IPrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void crearPrestamo(Long libroId, Long usuarioId, LocalDate fechaDevolucion) {
        Prestamo prestamo = new Prestamo();

        ///Seteamos el libro
        prestamo.setLibro(libroRepository.findById(libroId).orElseThrow(() ->
                new NoExisteObjectExeption("El libro no existe")));

        ///Seteamos el usuario
        prestamo.setUsuario(usuarioRepository.findById(usuarioId).orElseThrow(()->
                new NoExisteObjectExeption("El usuario no existe")));

        ///Seteamos el estado
        Estado estado = Estado.BIEN;
        prestamo.setEstado(estado);

        ///Seteamos la fecha del prestamo, osea la fecha en la que se creo
        LocalDate fecha = LocalDate.now();
        prestamo.setFechPrestamo(fecha);

        ///Seteamos la fecha de devolucion y si se devolvio o no, que en este caso como recie se crea
        ///el prestamo, todavia no se devolvio
        prestamo.setFechaDevolucion(fecha);
        prestamo.setDevolucion(false);

        ///Guardamos el prestamo en su repository y se lo modificamos a el usuario y el libro
        usuarioRepository.findById(usuarioId).get().agregarPrestamo(prestamo);
        libroRepository.findById(libroId).get().AgregarPrestamo(prestamo);
        prestamoRepository.save(prestamo);


    }
}
