package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Boleto {

    @Id
    private String codigo;
    private String fecha;
    
    @OneToOne
    private Espectaculo espectaculo;
    
    private String dni;
    private double precio;

    // Constructor vacío
    public Boleto() {
    }

    // Constructor con todos los campos
    public Boleto(String codigo, String fecha, Espectaculo espectaculo, String dni, double precio) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.espectaculo = espectaculo;
        this.dni = dni;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
