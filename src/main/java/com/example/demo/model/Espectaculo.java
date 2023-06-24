package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Espectaculo {

    @Id
    private String codigo;
    private String direccion;
    private String cantante;
    private String nombre_proveedor;
    private Double precio;

    // Agrega aquí los constructores, getters y setters

    // Constructor vacío
    public Espectaculo() {
    }

    // Constructor con todos los campos
    public Espectaculo(String codigo, String direccion, String cantante, String nombre_proveedor, Double precio) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.cantante = cantante;
        this.nombre_proveedor = nombre_proveedor;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getNombreProveedor() {
        return nombre_proveedor;
    }

    public void setNombreProveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
