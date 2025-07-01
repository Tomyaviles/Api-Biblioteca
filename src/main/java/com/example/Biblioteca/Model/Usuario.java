package com.example.Biblioteca.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<Prestamo> prestamos;
    private String telefono;
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




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
