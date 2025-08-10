package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario extends Persona{


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> prestamos = new ArrayList<>();
    private String telefono;

    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> misLibros = new ArrayList<>();


    public Usuario(String nombre, String apellido, String email, LocalDate fechaNacimiento, String telefono) {
        super(nombre, apellido, email, fechaNacimiento);
        this.telefono = telefono;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
