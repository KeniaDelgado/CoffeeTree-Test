package oraclegeneral;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    public static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    public static  String usuario ="CoffeeTreePT5";
    public static String contrasena = "abcd1234";
    public static Connection con;
    public static Statement st;
    public static String query = null;
    public static boolean verifyDB;
    public static  String newUsuario ="";
    public static String newContrasena = "";
    
   
    public static Boolean verificarUsuario(){
    try {
            con= Conexion.getDBConexion();
            if(con!=null){
                con.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            con=null;
            return false;
        }
        
    }
    
  
    public static Connection getDBConexion(){
        try {
            con= DriverManager.getConnection(url,usuario,contrasena);
            verifyDB = true; 
        } catch (SQLException ex) {
            con = null;
            verifyDB = false; 
        }
        return con;
    }
    
    
    public static Boolean creacionUsuario(){
        File file = new File("CrearUser.txt");
        newUsuario = usuario;
        newContrasena = contrasena;
        usuario = "system";
        contrasena = "system";
        int i=0;
        String[] create = {"create user "+ newUsuario +" identified by " + newContrasena,
                           "grant connect to "+ newUsuario,
                           "grant all privileges to "+ newUsuario+" identified by " + newContrasena};
        try {
//            FileReader in =  new FileReader(file.getAbsolutePath());
//            BufferedReader br = new BufferedReader(in);
            con = Conexion.getDBConexion();
            st = con.createStatement();
            for (int j = 0; j <= 2; j++) {
                System.out.println (create[i]);
                st.execute(create[j]);
            }
//            br.close();
              st.close();
              con.close();
            usuario = newUsuario;
            contrasena = newContrasena;
        } catch (Exception e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("Error");
                return false;
        }
        return true;
        
    }
    
    
    public static Boolean creacionBase(String us, String pw){
        usuario = us;
        contrasena = pw;
        FileReader fstream = null;
         File file = new File("CrearBase.txt");
        try {
            con=Conexion.getDBConexion();
            st = con.createStatement();
            fstream = new FileReader(file.getAbsolutePath());
            BufferedReader br = new BufferedReader(fstream);
            while (br.readLine()!= null)   {
                query = br.readLine().toString();
                System.out.println (query);
                st.executeUpdate(query);
            }
            br.close();
            st.close();
            con.close();
        } catch (Exception e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
                return false;
        }
        return true;
        
    }
    
    
}
