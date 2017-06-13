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
public class Pago {
    

    Boolean tipo ; // tipo = True(efectivo) tipo=false(tarjeta de credito)
    String numeroTarjeta;
    
    public Pago(){}
    
    public void crear_pago(Boolean tipo, String tarjeta){
     this.tipo = tipo;
     this.numeroTarjeta = tarjeta;
    }
    
    public String validar_pago(Pago p){
        if (p.getTipo().equals(true)){
            return "Pago en efectivo";
        }
        else if(p.getTipo().equals(false)){
            if(this.numeroTarjeta.matches("[0-9]*")){
                return "Pago con tarjeta";
            }
            else
                return "Tarjeta no válida";
        }
        else
            return "Tipo de pago incorrecto"; 
    }


    public Boolean getTipo() {
        return tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    Object stringPago() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
