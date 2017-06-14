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
    
    //Funcion que valida si el producto está fuera de stock de ser asi retorna 0, si esta dentro de stock retorna 1.
    public int validar_stock(){
        if (this.getStock() == 0 || this.getStock()< 0 || this.getStock() > 100)
            return 0;
        return 1;
    }
    //Funcion que retorna el número de stock del producto.
    public int getStock() {
        return stock;
    }
    
    
    //Funcion que retorna el nombre del producto
    public String getNombre() {
        return nombre;
    }
    //Funcion que retorna el precio del producto
    public double getPrecio() {
        return precio;
    }
    
    
    //Funcion que retorna un String indicando si el producto se creo correctamente.
    public String crear_producto(){
        if (this.validar_stock() == 1) {
            System.out.println("Usted ha creado:" + this.toString());
            
            return "Se creo el producto exitosamente!";
        }
        return "No se pudo crear el producto.Verifique el stock ingresado.";
    }
    
    //Funcion que retorna un String, donde muestra el nombre del producto.
    @Override //Esta permite visualizar el catalogo.
    public String toString() {
        return "Producto{" + "nombre=" + nombre + '}';
    }
    
    
    
}
