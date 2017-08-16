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
        System.out.println("\n(INICIAL) El catálogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString());
        Producto producto5 = new Producto("Ciprofloxacina","Medicina",50,15,11.42);
        String resultado = producto5.crear_producto();
        catalogo.add(producto5);
        System.out.println("\n(FIN) El catálogo de la farmacia es: " + catalogo.size());
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
//Yooo

	@Test
    public void testIntegracion_Test4(){
        System.out.println("----Test 4----");
        Date hora=new Date();
        //inicio del test
        Producto p1 = obtener_producto_catalogo(catalogo,"Analgan");
        Producto p2 = obtener_producto_catalogo(catalogo,"Dicloflenaco");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
        System.out.println(carrito.toString());
        
        
        Pago pago=new Pago();
        pago.crear_pago(true,"");
        Cliente client=new Cliente("Kerly", 2, pago);
        System.out.println(client.InfoPer());
        System.out.println( pago.validar_pago(pago));
        Pedido pedido= new Pedido(carrito,hora,client);
        
        System.out.println(pedido.ValidHora());
        assertEquals("Horario disponible",pedido.ValidHora());
        
    }
    /*
    TEST 5
    FUNCIONALIDAD
    F1 OBTENER EL RECARGO
    F2 TOTAL A PAGAR
    
    El usuario ingresa al sistema, agrega los productos al carrito, visualiza  el pedido. Después da clic ensiguiente, donde ingresa nombre, sector,  tipo  de pagoy     da     clic     en Confirmar pedido.
    luego se muestra su recargo, y el total a pagar del usuario
    
    productos_selec  = Analgan, Diclofenaco
    cantidad = 2,2
    pago=tarjeta
    Nombre=”Becky”
    sector=Centro
    horario=hora actual
    
    el usuario da click en confirmar el pedido y se muestra su recargo y su total a pagar
    
    
    El usuario da click en confirmar el pedido Y se muetsra su total a pagar
    */
    //a
    @Test
    public void testIntegracion_Test5(){
        System.out.println("----Test 5----");
        
        
        Date hora=new Date();
        //inicio del test
        Producto p1 = obtener_producto_catalogo(catalogo,"Analgan");
        Producto p2 = obtener_producto_catalogo(catalogo,"Dicloflenaco");
        DetallePedido detalle1 = new DetallePedido(p1,2);
        DetallePedido detalle2 = new DetallePedido(p2,2);
        carrito.add(detalle1);
        carrito.add(detalle2);
        System.out.println(carrito.toString());
        
  
        Pago pago=new Pago();
        pago.crear_pago(false,"");
        Cliente client=new Cliente("Becky", 2, pago);
        System.out.println(client.InfoPer());
        System.out.println( pago.validar_pago(pago));
        Pedido pedido= new Pedido(carrito,hora,client);
        
        System.out.println(pedido.ValidHora());
        double subtotal=detalle1.SubtotalDeProducto() + detalle2.SubtotalDeProducto();
        double recargo= 0.0;
        System.out.println(pedido.TotalPedido());
        
        assertEquals(26.0,pedido.TotalPedido(),1);
         
        
    }
    

