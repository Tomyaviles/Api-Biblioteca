package com.example.Biblioteca.Model.DTOs;

import java.time.LocalDate;

public class PrestamoDTO {

    private String usuario;
    private String Titulolibro;
    private LocalDate fechaDevolucion;


    public PrestamoDTO(String usuario, String titulolibro, LocalDate fechaDevolucion) {
        this.usuario = usuario;
        Titulolibro = titulolibro;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTitulolibro() {
        return Titulolibro;
    }

    public void setTitulolibro(String titulolibro) {
        Titulolibro = titulolibro;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
