package com.example.Biblioteca.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
    }

    ///GETTER Y SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
