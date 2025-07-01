package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fechPrestamo;
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    private boolean devolucion;
    private Estado estado;

    public Prestamo(LocalDate fechPrestamo, LocalDate fechaDevolucion, Usuario usuario, Libro libro, boolean devolucion, Estado estado) {
        this.fechPrestamo = fechPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuario = usuario;
        this.libro = libro;
        this.devolucion = devolucion;
        this.estado = estado;
    }

    public Prestamo() {
    }


                    ///GETTER Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechPrestamo() {
        return fechPrestamo;
    }

    public void setFechPrestamo(LocalDate fechPrestamo) {
        this.fechPrestamo = fechPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


                    ///METODOS
}
