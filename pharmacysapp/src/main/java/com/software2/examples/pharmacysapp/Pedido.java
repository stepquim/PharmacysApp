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

    public Cliente getCliente() {
        return cliente;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
    //Validar Hora
    public String ValidHora(){
        DateFormat Horanow = new SimpleDateFormat("HH:mm");
        int h=this.hora.getHours();
        if(this.cliente.sector==1){
            if(h >= 8 && h < 23){
                System.out.print("Hora: " + Horanow.format(hora) + " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }else if(this.cliente.sector==2 || this.cliente.sector==3){
            //8 a 9
            if(h >= 8 && h < 21){
                System.out.println("Hora: " + Horanow.format(hora)+ " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }
         return "Sector no válido";
    }
    
    public double GetRecargo(Cliente cliente, double subtotalProductos){
        if(subtotalProductos <= 10.00 && subtotalProductos > 0){
            if (cliente.sector==1){
                return this.recargo=4.00;
            }
            else if (cliente.sector==2 || this.cliente.sector==3)
                return this.recargo=2.00;
            else{
                System.out.println("Sector no válido");
            }
        }
        return this.recargo;
    }
    
    public double TotalPedido(){
        double total=0.0,r=0.0;
        for (DetallePedido pe : this.pedido){
            total= total + pe.SubtotalDeProducto();
        }
        
        r=this.GetRecargo(cliente, total);
        this.setTotal(total + r);
        return this.Total;
    }
    
    public String ToStringTotal(){
        return "Se completo su pedido";
    }
     
     
}
