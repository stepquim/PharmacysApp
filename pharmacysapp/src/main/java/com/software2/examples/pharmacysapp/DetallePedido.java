/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;


/**
 *
 * @author Stephany
 */
public class DetallePedido {
   Producto p;
   int cantidad;
   double subtotal;

    public DetallePedido(Producto p, int cantidad) {
        this.p = p;
        this.cantidad = cantidad;
        this.subtotal=0;
    }
    //Funcion que retorna el tipo de dato producto
    public Producto getP() {
        return p;
    }
    //Funcion que retorna la cantidad que solicito de un producto.
    public int getCantidad() {
        return cantidad;
    }
    
    //Funcion que retorna el subtotal de un producto.
    public double SubtotalDeProducto(){
        this.subtotal=(this.p.getPrecio())*(this.getCantidad());
            return this.subtotal;
    }
   
    //Funcion que retorna el detalle del pedido: producto, cantidad que pidió y el subtotal.
    @Override
    public String toString() {
        return "DetallePedido{" + "p=" + this.getP() + ", cantidad=" + this.getCantidad() +", subtotal= "+ this.SubtotalDeProducto() + "}";
    }
    
    
      
}
