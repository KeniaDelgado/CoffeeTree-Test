package controladores;

import datos.Producto;
import java.util.List;
import java.util.stream.Collectors;
import oraclegeneral.Conexion;


public class Productos extends BaseController{
    
    public static List<Productos> productosMostrar(String nom){

        String query = "select * from productos where nombre like '" + nom +"%'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    
    public static List<Productos> productosMostrarNo(String nom,String nomno){

        String query = "select * from productos where nombre like '" + nom +"%' and not nombre like'"
                        + nomno + "%'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    
    public static List<Productos> crepasUnSal(){

        String query = "select * from productos where nombre like 'Crepa jamon' or nombre like 'Crepa queso' or nombre like 'Crepa champ%' and nombre not like 'Crepa champhi'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    
    public static List<Productos> crepasDosSal(){

        String query = "select * from productos where nombre like '%quesoc%' or nombre like '%quesom%' or nombre like '%quesop%' or nombre like '%jamonc%' or nombre like '%jamonp%' or nombre like '%champhi%'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    
    public static List<Productos> crepasUnDul(){

        String query = "select * from productos where nombre like '%philad%' or nombre like '%nutella%' or nombre like '%leche%' or nombre like '%cajeta%' or nombre like 'Crepa fresa' or nombre like '%zarzamora%'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    
    public static List<Productos> crepasDosDul(){

        String query = "select * from productos where nombre like '%nutcaje%' or nombre like '%nutelphia%' or nombre like '%nutfresa%' or nombre like '%nutzarza%' or nombre like '%nutchera%' or nombre like '%cajelphia%' or nombre like '%cajfresa%'or nombre like '%cajzarza%' or nombre like '%cajchera%' or nombre like '%philafresa%' or nombre like '%philazarza%' or nombre like '%philachera%' or nombre like '%frezarza%' or nombre like '%frechera%' or nombre like '%zarzachera%'";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
    public static List<Productos> productosRecetas(){

        String query = "select nombre from productos";
        List<Productos> productos = (List<Productos>) Productos.select(Conexion.getDBConexion(), query, Producto.class);
        System.out.println("productos = " + productos.stream().collect(Collectors.toList()));
        
        return productos;
    }
}
