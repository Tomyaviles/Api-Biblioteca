package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutorId(Long idAutor);
}
