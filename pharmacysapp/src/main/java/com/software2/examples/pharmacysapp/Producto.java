/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;
import java.util.ArrayList;
/**
 *
 * @author Stephany
 */
public class Producto {
    String nombre; // El nombre del producto.
    String descripcion; // La descripcion del producto.
    int stock; // El stock del producto.
    int limite; //El limite de ese producto por pedido
    double precio;

    public Producto(){}
    
    public Producto(String nombre, String descripcion, int stock, int limite, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.limite = limite;
        this.precio = precio;
    }
    
    
    public int validar_stock(){
        if (this.getStock() == 0 || this.getStock()< 0 || this.getStock() > 100)
            return 0;
        return 1;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    public String crear_producto(){
        if (this.validar_stock() == 1) {
            System.out.println("Usted ha creado:" + this.toString());
            
            return "Se creo el producto exitosamente!";
        }
        return "No se pudo crear el producto.Verifique el stock ingresado.";
    }
    
    
    @Override //visualiza catalogo
    public String toString() {
        return "Producto{" + "nombre=" + nombre + '}';
    }
    
    
    
}
