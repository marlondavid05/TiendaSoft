/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasoft;
import java.util.Scanner;
/**
 *
 * @author Marlangas
 */
public class TIENDA {
    private String producto;
    private double cantidad, valor;
    

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getProducto() {
        return producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getValor() {
        return valor;
    }
    
    public void Mostrar_Inventario(){
        System.out.println("Producto: "+producto);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Valor por Unidad: "+valor);
    }
    
    public void  Agregar(){
        Scanner scanf = new Scanner(System.in);
 
        System.out.println("Por favor ingrese el nombre del producto que desea agregar:");
        setProducto(scanf.nextLine());
        System.out.println("Por favor ingrese el valor del producto que desea agregar:");
        setValor(scanf.nextDouble());
        System.out.println("Por favor ingrese las cantidades disponibles:");
        setCantidad(scanf.nextDouble());
        System.out.println("Producto Almacenado!!!");
        System.out.println("");
    }
    
    public int Buscar(String buscar){
        
        if( buscar.compareTo( getProducto() ) == 0 ){ // Pregunta si los nombres con iguales
            System.out.println("Se ha encontrado el producto!!!");
            System.out.println();
            System.out.println("El nombre del producto es: "+getProducto());
            System.out.println("El valor es: "+getValor());
            System.out.println("Las cantidades disponibles son: "+getCantidad());  
            return 1;
        }else{
            return 0;
        }     
    }
    
    
}
