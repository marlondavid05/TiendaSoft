/*

 */
package tiendasoft;
import java.util.Scanner;
/**
 *
 * @author Marlangas
 */
public class TiendaSoft {  
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int accion;
        TIENDA producto[] = new TIENDA[100]; // Máximo soporta 100 productos OJO CON FUNCION AGREGAR!!!!!!!!!!!
        TIENDA[] temporal= new TIENDA[100];
        int cantidad=0, ganancias=0;
        double[] ventas = new double[100];
        String buscar, eliminar, nombre;
        int flagbuscar=0,i,flageliminar=0, flagventa=0, j=0;//j salta para eliminar
        
        for(i=0; i<100; i++){
            ventas[i]=0;
            producto[i]= new TIENDA();
            temporal[i]= new TIENDA();
        }
        
        do{
            System.out.println("Ingrese la opción que desea realizar:");
            System.out.println();
            System.out.println("1. Agregar Producto");
            System.out.println("2. Buscar Producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Realizar Venta");
            System.out.println("6. Mostrar Ganancias totales");
            System.out.println("7. Salir");
            accion=scanf.nextInt();
            scanf.nextLine();
            j=0;

            switch (accion){
                    case 1:
                        producto[cantidad].Agregar();
                        cantidad++;                       
                        break;
                        
                    case 2:
                        System.out.println("Por favor ingrese el nombre del producto que desea buscar:");
                        buscar=scanf.nextLine();
                        
                        for(i=0; i<cantidad; i++){
                                flagbuscar= producto[i].Buscar(buscar);
                        }
                        if(flagbuscar==0){
                            System.out.println("El producto que busca no se encuentra en la tienda");
                        }
                        break;
                        
                    case 3:
                        System.out.println("Por favor ingrese el nombre del producto que desea Eliminar:");
                        eliminar=scanf.nextLine();
                        flageliminar=0;
                        
                        for(i=0; i<cantidad; i++){
            
                            if( eliminar.compareTo( producto[i].getProducto() ) == 0 ){ // Pregunta si los nombres con iguales
                                flageliminar=1;  
                                j++; // Se salta el producto q se va a eliminar
                            }
                            temporal[i]=producto[j];
                            
                            j++;
                        }
                        if(flageliminar==0){
                            System.out.println("El producto que desea eliminar no se encuentra en la tienda");
                        }else{
                            cantidad--;
                            for(i=0; i<cantidad; i++){
                                producto[i]=temporal[i];
                            } 
                            System.out.println("Se ha eliminado el Producto!!!");
                        } 
                        break;
                        
                    case 4:
                        System.out.println("El inventario de la tienda es:");
                        System.out.println();

                        for(i=0; i<cantidad; i++){
                                producto[i].Mostrar_Inventario();
                                System.out.println();
                        } 
                        break;
                        
                    case 5:
                        System.out.println("Por favor ingrese el nombre del producto que desea vender:");
                        nombre=scanf.nextLine();

                        for(i=0; i<cantidad; i++){

                            if( nombre.compareTo( producto[i].getProducto() ) == 0 ){ // Pregunta si los nombres con iguales
                                System.out.println("Cuantas cantidades desea vender?");
                                ventas[i]=scanf.nextDouble();
                                flagventa=1;
                                if( ventas[i] <=  producto[i].getCantidad()){
                                    producto[i].setCantidad( producto[i].getCantidad()-ventas[i] );
                                    System.out.println("Venta EXITOSA!!!");
                                }else{
                                    System.out.println("La cantidad ingresada excede a las disponibles!!!");
                                    ventas[i]=0;
                                }               
                            }                                
                        }
                        if(flagventa==0){
                            System.out.println("El producto ingresado no se encuentra en la tienda!!!");
                        }
                        break;
                        
                    case 6:
                        for(i=0; i<cantidad; i++){
                            if(ventas[i] != 0){
                                System.out.println("Del producto "+producto[i].getProducto()+" se vendieron "+ventas[i]+" unidades, Total venta: $"+(producto[i].getValor()*ventas[i]));
                                ganancias+=(producto[i].getValor()*ventas[i]);
                            }
                        }
                        System.out.println("El total de ganancias en ventas es: $"+ganancias);
                        System.out.println();
                        break;
                        
                    case 7:                    
                        System.out.println("¡HASTA LA PROXIMA!");
                        break;
                    default:
                        System.out.println("Opcion no valida!!!");
                        break;
                }
        }while(accion>0 && accion<7);
    }
    
    
    

    
 
    
    
    
}
