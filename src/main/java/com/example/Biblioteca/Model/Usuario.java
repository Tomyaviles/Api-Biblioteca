package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario extends Persona{


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos;
    private String telefono;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Libro> misLibros;


    public Usuario(String nombre, String apellido, String email, LocalDate fechaNacimiento, Long id) {
        super(nombre, apellido, email, fechaNacimiento);
        this.prestamos = new ArrayList<>();
        this.telefono = "";
        this.misLibros = new ArrayList<>();
    }

    public Usuario() {
    }


                    ///Getter y Setters






    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Libro> getMisLibros() {
        return misLibros;
    }

    public void setMisLibros(List<Libro> misLibros) {
        this.misLibros = misLibros;
    }

    ///METODOS
    public void agregarPrestamo(Prestamo prestamo)
    {
        prestamos.add(prestamo);
    }

    public void agregarLibro(Libro libro)
    {
        misLibros.add(libro);
    }




}
