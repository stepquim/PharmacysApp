/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;
import com.software2.examples.pharmacysapp.Producto;
import com.software2.examples.pharmacysapp.DetallePedido;
import com.software2.examples.pharmacysapp.Pago;  
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Stephany
 */
public class PedidoTest {
    
    private static ArrayList<Producto> catalogo;
    private static ArrayList<DetallePedido> carrito;
    
    public static void initCatalogo() {
        
       
        catalogo = new ArrayList<Producto>();
        carrito = new ArrayList<DetallePedido>();
        
        Producto producto1 = new Producto("Dicloflenaco","Medicina",4,1,10.5);
        Producto producto2 = new Producto("Buscapina","Medicina",20,5,5.6);
        Producto producto3 = new Producto("Analgan","Medicina",10,2,2.50);
        Producto producto4 = new Producto("Redoxon","Medicina",30,5,7.80);
        
        catalogo.add(producto1);
        catalogo.add(producto2);
        catalogo.add(producto3);
        catalogo.add(producto4);
    }
    
    
    public Producto obtener_producto_catalogo(ArrayList<Producto> productos, String clave){
        Producto encontrado = null;
        
        for (Producto producto : productos) {
             if(producto.getNombre().equals(clave))
                 encontrado = producto;
            }
        return encontrado;
    
    }
    
    @Before
    public void beforeEachTest() {
        initCatalogo();
    }

    @After
    public void afterEachTest() {
      
    }

    @Test
    public void testIntegracion_producto_catalogo() {
        System.out.println("----Test 1----"); 
        System.out.println("\n(INICIAL) El catalogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString());
        Producto producto5 = new Producto("Ciprofloxacina","Medicina",50,15,11.42);
        String resultado = producto5.crear_producto();
        catalogo.add(producto5);
        System.out.println("\n(FIN) El catalogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString()); 
        
        assertEquals("Se creo el producto exitosamente!", resultado); //experado,obtenido
        
        System.out.println("----Test 1----\n"); 
    }
    
    @Test  
    public void testIntegracion_catalogo_carrito() {
        System.out.println("----Test 2----");        
        Producto p = obtener_producto_catalogo(catalogo,"Redoxon"); //simulo que lo agrego al carrito
        DetallePedido detalle1 = new DetallePedido(p,5); //Simulo que selecciono 5
        carrito.add(detalle1);
        //visualizar el pedido con los productos seleccionados.
        System.out.println("*******Carrito*****");
        System.out.println(carrito.toString());
        assertEquals(1, carrito.size()); //experado,obtenido
        System.out.println("----Test 2----\n"); 
    }
    
   
    
    @Test  
    public void testIntegracion_PagoSubtotal() {
        System.out.println("----Test 3----");      
        Producto p1 = obtener_producto_catalogo(catalogo,"Analgan");
        Producto p2 = obtener_producto_catalogo(catalogo,"Buscapina");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
        //visualizar el pedido con los productos seleccionados.
        System.out.println(carrito.toString());
        Pago pa=new Pago();
        //Ingresa el tipo de pago
        pa.crear_pago(true,"");
        Cliente client=new Cliente("Juan", 1, pa);
        System.out.println(client.InfoPer());
        System.out.println( pa.validar_pago(pa));
        double subt=detalle1.subtotal +detalle2.subtotal;
        System.out.println("El subtotal a pagar es: " + subt);
        assertEquals(true, pa.getTipo());//experado,obtenido
        System.out.println("----Test 3----\n");      
    }
    
     @Test  
     public void testIntegracion_ConfirmarTipoPago(){
       System.out.println("-------test 4-------- ");
       int hora,minutos,segundos;
       Date ahora= new Date();
       SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
       Producto p = obtener_producto_catalogo(catalogo,"Analgan");
       Producto p2 = obtener_producto_catalogo(catalogo,"Dicloflenaco");
       DetallePedido detalle1 = new DetallePedido(p,1);
       DetallePedido detalle2 = new DetallePedido(p2,1);
       carrito.add(detalle1);
       carrito.add(detalle2);
       //visualiza el pedido
       System.out.println(carrito.toString());
       Pago pa=new Pago();
       pa.crear_pago(true,"");
       Cliente client=new Cliente("Kerly", 2, pa);
       System.out.println(client.InfoPer());
       System.out.println( pa.validar_pago(pa));
       double subt=detalle1.subtotal +detalle2.subtotal;
       System.out.println("El subtotal a pagar es: " + subt);
       //assertEquals(true, pa.getTipo());//experado,obtenido
       Pedido pe=new Pedido(carrito,ahora,client);
       assertEquals("Horario disponible",pe.ValidHora());
       System.out.println("----Test 4----\n");    
     }
     
     
     @Test  
     public void testIntegracion_RecargoyTotal(){
       System.out.println("-------test 5-------- ");
       int hora,minutos,segundos;
       Date ahora= new Date();
       SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
       Producto p = obtener_producto_catalogo(catalogo,"Analgan");
       Producto p2 = obtener_producto_catalogo(catalogo,"Dicloflenaco");
       DetallePedido detalle1 = new DetallePedido(p,1);
       DetallePedido detalle2 = new DetallePedido(p2,1);
       carrito.add(detalle1);
       carrito.add(detalle2);
       //visualiza el pedido
       System.out.println(carrito.toString());
       Pago pa=new Pago();
       pa.crear_pago(true,"");
       Cliente client=new Cliente("Kerly", 2, pa);
       System.out.println(client.InfoPer());
       System.out.println( pa.validar_pago(pa));
       double subt=detalle1.subtotal +detalle2.subtotal;
       System.out.println("El subtotal a pagar es: " + subt);
       //assertEquals(true, pa.getTipo());//experado,obtenido
       Pedido pe=new Pedido(carrito,ahora,client);
       pe.GetRecargo(client, subt);
       assertEquals(13.0,pe.TotalPedido(),1);
       System.out.println("----Test 5----\n");  
     }
}

/* 
F1: obtener el recargo
F2: obtener el total a pagar

Descripcion
el usuario ingresa al sistema, agrega los productos al carrito, vizualiza el pedido
despues da clic en siguiente, donde ingresa el nombre, sector, tipo de pago y da clic 
en confirmar pedido y acontinuacion le muestra el total de su pedido.
Nota: el sistema compara si el total a pagar es el esperado, al hacer el pedido y con los recargos
en el caso que sea necesario 

Datos de prueba:
productos seleccionados: analagan,Diclofenaco;
cantidad=1,1;
pago=Efectivo,
Nombre="kerly";
sector=Centro;
horario=hora actual;

Resultado Esperado

El usuario selecciona su pedido y da clic en confirmar y recebira el total de la compra
cuyo valor es $13.0

Resultado obtenido:
el usuario selecciona sus productos y le muestra el total de su compra cuyo valor es $13.0
*/

