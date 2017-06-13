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
     public int sector; // sector = {1 norte,2 centro ,3 sur}
     Pago pago;
     public double recargo;
     public double Total;

    public Pedido(ArrayList<DetallePedido> pedido,Date hora, int sector, Pago pago) {
        this.pedido = pedido;
        this.hora= hora;
        this.sector = sector;
        this.pago = pago;
        this.recargo=0;
        this.Total =0;
    }
    public String GetSector(){
         switch (this.sector) {
             case 1:
                 return "Norte";
             case 2:
                 return "Centro";
             case 3:
                 return "Sur";
             default:
                 break;
         }
         return null;
    }
    //Validar Hora
    public String ValidHora(){
        DateFormat Horanow = new SimpleDateFormat("HH:mm");
        int h=this.hora.getHours();
        if(this.sector==1){
            if(h >= 8 && h < 23){
                System.out.print("Hora: " + Horanow.format(hora) + " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }else if(sector==2 || sector==3){
            //8 a 9
            if(h >= 8 && h < 21){
                System.out.println("Hora: " + Horanow.format(hora)+ " "); 
                return  "Horario disponible";
            }else
                return "Fuera de Horario disponible";
        }
         return "Sector no válido";
    }
    
    public double GetRecargo(int sector, double subtotalProductos){
        if(subtotalProductos <= 10.00 && subtotalProductos > 0){
            if (sector==1){
                return this.recargo=4.00;
            }
            else if (sector==2 || sector==3)
                return this.recargo=2.00;
            else{
                System.out.println("Sector no válido");
            }
        }
        return this.recargo;
    }
    
    
    
    public String ToStringTotal(){
        return "Se completo su pedido";
    }
     
     
}
