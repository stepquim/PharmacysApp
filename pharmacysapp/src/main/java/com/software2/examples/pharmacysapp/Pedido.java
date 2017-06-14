/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Stephany
 */
public class Pedido {
     public ArrayList<DetallePedido> pedido;
     Date hora;
     Cliente cliente;
     public double recargo;
     public double Total;

    public Pedido(ArrayList<DetallePedido> pedido,Date hora,Cliente cliente) {
        this.pedido = pedido;
        this.hora= hora;
        this.cliente=cliente;
        this.recargo=0;
        this.Total =0;
    }

    
    //Funcion que retorna un tipo de dato Cliente.
    public Cliente getCliente() {
        return cliente;
    }
    //Funcion que modifica el valor total a pagar.
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
    //Funcion que valida si esta dentro del horario de atención y retorna un String indicando si esta dentro o no.
    public String ValidHora(){
        DateFormat Horanow = new SimpleDateFormat("HH:mm");
        int h=this.hora.getHours();
        if(this.cliente.sector==1){//Sector Norte
            if(h >= 8 && h < 23){
                System.out.print("Hora: " + Horanow.format(hora) + " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }else if(this.cliente.sector==2 || this.cliente.sector==3){ //Sector Centro y Sur
            if(h >= 8 && h < 21){
                System.out.println("Hora: " + Horanow.format(hora)+ " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }
         return "Sector no válido";
    }
    //Funcion donde ingresa los parametros: Cliente y subtotal del pedido para retornar al recargo a pagar que es de tipo double.
    public double GetRecargo(Cliente cliente, double subtotalProductos){
        if(subtotalProductos <= 10.00 && subtotalProductos > 0){ //Si el subtotal es menor que 10, tiene recargo.
            if (cliente.sector==1){
                return this.recargo=4.00;//sector: Norte
            }
            else if (cliente.sector==2 || this.cliente.sector==3)
                return this.recargo=2.00;//sector: Centro y Sur
            else{
                System.out.println("Sector no válido");
            }
        }
        return this.recargo;// El subtotal es mayor que 10, tiene recargo 0.
    }
    
    //Funcion que retorna el Total del pedido, que engloba el subtotal de los productos añadidos al carrito y el recargo.
    public double TotalPedido(){
        double total=0.0,r=0.0;
        for (DetallePedido pe : this.pedido){
            total= total + pe.SubtotalDeProducto();
        }
        
        r=this.GetRecargo(cliente, total);
        this.setTotal(total + r);
        return this.Total;
    }
    
    //Funcion que retorna un String indicando que la transaccion fue completada.
    public String ToStringTotal(){
        return "Se completo su pedido";
    }
     
     
}
