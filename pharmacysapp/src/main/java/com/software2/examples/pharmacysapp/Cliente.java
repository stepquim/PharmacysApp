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
public class Cliente {
    public String Name;
    public int sector;
    Pago pago;

    public Cliente(String Name, int sector, Pago pago) {
        this.Name = Name;
        this.sector = sector;
        this.pago = pago;
    }

    public String getName() {
        return Name;
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
    
    public String InfoPer(){
        return "Usted ingreso la siguiente información" + "\nNombre:" + Name + "\nSector=" + sector;
    }

    @Override
    public String toString() {
        return "Información correcta";
    }
    
}
